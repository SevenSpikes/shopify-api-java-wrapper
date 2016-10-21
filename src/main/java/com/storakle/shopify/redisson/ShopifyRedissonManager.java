package com.storakle.shopify.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class ShopifyRedissonManager
{
    private String _nodeAddress;
    private String _myShopifyUrl;
    private RedissonClient _redissonClient;
    private final long MAXIMUM_SHOPIFY_CREDITS = 36;

    public ShopifyRedissonManager(String nodeAddress, String myShopifyUrl)
    {
        _nodeAddress = nodeAddress;
        _myShopifyUrl = myShopifyUrl;
    }

    public RedissonClient getRedissonClient()
    {
        if(_redissonClient == null)
        {
            Config config = new Config();
            config.useElasticacheServers()
                    .setScanInterval(2000) // cluster state scan interval in milliseconds
                    .addNodeAddress(_nodeAddress);

            _redissonClient = Redisson.create(config);
        }

        return _redissonClient;
    }

    public String getMyShopifyUrl()
    {
        return _myShopifyUrl;
    }

    public String getRemainingCreditsKey()
    {
        return "remainingCredits_" + _myShopifyUrl;
    }

    public String getLastRequestTimeKey()
    {
        return "lastRequestTime_" + _myShopifyUrl;
    }

    public String getIsDefaultRemainingCreditsValueSetKey()
    {
        return "isDefaultRemainingCreditsValueSet" + _myShopifyUrl;
    }

    public long getCreditLimit()
    {
        return MAXIMUM_SHOPIFY_CREDITS;
    }

    public long calculateAvalableCredits(long createdCalls)
    {
        return MAXIMUM_SHOPIFY_CREDITS - createdCalls;
    }
}
