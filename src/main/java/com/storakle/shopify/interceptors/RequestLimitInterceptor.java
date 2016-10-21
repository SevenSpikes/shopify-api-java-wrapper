package com.storakle.shopify.interceptors;

import com.storakle.shopify.redisson.ShopifyRedissonManager;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class RequestLimitInterceptor implements RequestInterceptor
{
    private ShopifyRedissonManager _shopifyRedissonManager;

    public RequestLimitInterceptor(ShopifyRedissonManager shopifyRedissonManager)
    {
        _shopifyRedissonManager = shopifyRedissonManager;

//        _shopifyRedissonManager.getRedissonClient().getKeys().flushall();
    }

    @Override
    public void apply(RequestTemplate template)
    {
        Boolean tryGetCredit = true;

        RedissonClient redisson = _shopifyRedissonManager.getRedissonClient();

        while (tryGetCredit)
        {
            RLock lock = redisson.getLock(_shopifyRedissonManager.getMyShopifyUrl());

            RAtomicLong isDefaultRemainingCreditsValueSet = redisson.getAtomicLong(_shopifyRedissonManager.getIsDefaultRemainingCreditsValueSetKey());

            RAtomicLong remainingCreditsAtomic = redisson.getAtomicLong(_shopifyRedissonManager.getRemainingCreditsKey());

            if(isDefaultRemainingCreditsValueSet.get() == 0)
            {
                remainingCreditsAtomic.set(_shopifyRedissonManager.getCreditLimit());
                isDefaultRemainingCreditsValueSet.set(1);
            }

            RAtomicLong lastRequestTimeAtomic = redisson.getAtomicLong(_shopifyRedissonManager.getLastRequestTimeKey());
            Long remainingCredits = remainingCreditsAtomic.get();

            if(remainingCredits > 0)
            {
                // These values are set here, because a request can be made while the current request is still in progress.
                // We set the actual values inside the decoder (when the request is complete), but if we don't set them here
                // as well a raised condition can occur.
                remainingCreditsAtomic.set(remainingCredits - 1);
                lastRequestTimeAtomic.set(System.currentTimeMillis());

                tryGetCredit = false;
                lock.unlock();
            }
            else
            {
                // Check if there were enough time since the last request time.
                // If the latest request's remaining calls were 0 and no calls were made after that, the remaining credits
                // will not be updated. This is why the last request time is used as well.
                long availableCalls = (long)Math.floor((System.currentTimeMillis() - lastRequestTimeAtomic.get())/500);

                if(availableCalls > 0)
                {
                    remainingCreditsAtomic.set(availableCalls - 1);
                    lastRequestTimeAtomic.set(System.currentTimeMillis());

                    tryGetCredit = false;
                    lock.unlock();
                }
                else
                {
                    lock.unlock();

                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println("Error while waiting for available Shopify call credit. " + e.getMessage());
                    }
                }
            }
        }
    }
}
