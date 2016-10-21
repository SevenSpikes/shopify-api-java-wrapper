package com.storakle.shopify.jackson;

import com.storakle.shopify.redisson.ShopifyRedissonManager;
import feign.Response;
import feign.jackson.JacksonDecoder;
import org.assertj.core.util.Strings;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public class ShopifyJacksonDecoder extends JacksonDecoder
{
    private ShopifyRedissonManager _shopifyRedissonManager;

    public ShopifyJacksonDecoder(ShopifyRedissonManager shopifyRedissonManager)
    {
        _shopifyRedissonManager = shopifyRedissonManager;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException
    {
        Collection<String> shopifyApiCallLimitHeader = response.headers().get("HTTP_X_SHOPIFY_SHOP_API_CALL_LIMIT");

        String[] callLimitValues = shopifyApiCallLimitHeader.iterator().next().split("/");

        if(!Strings.isNullOrEmpty(callLimitValues[0]))
        {
            Long createdCalls = Long.parseLong(callLimitValues[0]);

            Long remainingCalls = _shopifyRedissonManager.calculateAvalableCredits(createdCalls);

            System.out.println("Remaining Credits: " + remainingCalls);

            RedissonClient redisson = _shopifyRedissonManager.getRedissonClient();

            RLock lock = redisson.getLock(_shopifyRedissonManager.getMyShopifyUrl());

            RAtomicLong remainingCreditsAtomic = redisson.getAtomicLong(_shopifyRedissonManager.getRemainingCreditsKey());
            RAtomicLong lastRequestTimeAtomic = redisson.getAtomicLong(_shopifyRedissonManager.getLastRequestTimeKey());

            remainingCreditsAtomic.set(remainingCalls);
            lastRequestTimeAtomic.set(System.currentTimeMillis());

            lock.unlock();
        }

        return super.decode(response, type);
    }
}
