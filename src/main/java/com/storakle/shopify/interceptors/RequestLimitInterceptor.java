package com.storakle.shopify.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.redisson.Redisson;
import org.redisson.api.RPermitExpirableSemaphore;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

import static feign.Util.checkNotNull;

public class RequestLimitInterceptor implements RequestInterceptor
{
    private RPermitExpirableSemaphore _semaphore;

    public RequestLimitInterceptor(String nodeAddress, String myShopifyUrl)
    {
        checkNotNull(nodeAddress, "nodeAddress");
        checkNotNull(myShopifyUrl, "myShopifyUrl");

        Config config = new Config();
        config.useElasticacheServers()
                .setScanInterval(2000) // cluster state scan interval in milliseconds
                .addNodeAddress(nodeAddress);

        RedissonClient _redissonClient = Redisson.create(config);

        _semaphore = _redissonClient.getPermitExpirableSemaphore(myShopifyUrl);

        // If there are no permits set this will throw a NullPointerException.
        // This means that the permits should be added. If the addPermits is executed more than once,
        // each consecutive call will add the permits to the existing ones. eg: 35, 70, etc.
        // The permits are set to 35 and not 40, because there should be a reserve, so that there are permits available
        // for other things, for example requests made by the shopify plugin.
        try
        {
            int permits = _semaphore.availablePermits();
            System.out.println("Number of existing permits: " + permits);

        }
        catch (NullPointerException ex)
        {
            _semaphore.addPermits(35);
        }
    }

    @Override
    public void apply(RequestTemplate template)
    {
        try
        {
            Boolean tryToAcquirePermit = true;

            while (tryToAcquirePermit)
            {
                System.out.println("Available permits: " + _semaphore.availablePermits());

                String permitId = _semaphore.tryAcquire(1000, 500, TimeUnit.MILLISECONDS);

                System.out.println("Permit acquired with ID: " + permitId);
                System.out.println("Available permits after permit were acquired: " + _semaphore.availablePermits());

                // Stop the loop if the permit is acquired
                if (permitId != null)
                {
                    tryToAcquirePermit = false;
                }
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            System.out.println("Error acquiring the lock permit. " + e.getMessage());
        }

    }
}
