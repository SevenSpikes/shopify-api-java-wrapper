package com.storakle.shopify;

import com.storakle.shopify.interceptors.ContentTypeRequestInterceptor;
import com.storakle.shopify.interceptors.OAuthRequestInterceptor;
import com.storakle.shopify.interceptors.RequestLimitInterceptor;
import com.storakle.shopify.jackson.ShopifyJacksonDecoder;
import com.storakle.shopify.redisson.ShopifyRedissonManager;
import feign.Feign;
import feign.RequestInterceptor;
import feign.jackson.JacksonEncoder;

import java.util.ArrayList;

public class ShopifyApiFactory
{
    public static ShopifyApiClient create(String accessToken, String myShopifyUrl, String nodeAddress)
    {
        ShopifyRedissonManager shopifyRedissonManager = new ShopifyRedissonManager(nodeAddress, myShopifyUrl);

        // Prepare the request interceptors
        ArrayList<RequestInterceptor> requestInterceptors = new ArrayList<>();

        requestInterceptors.add(new OAuthRequestInterceptor(accessToken));
        requestInterceptors.add(new ContentTypeRequestInterceptor());
        requestInterceptors.add(new RequestLimitInterceptor(shopifyRedissonManager));

        return Feign.builder()
                .decoder(new ShopifyJacksonDecoder(shopifyRedissonManager))
                .encoder(new JacksonEncoder())
                .requestInterceptors(requestInterceptors)
//                .logger(new Logger.JavaLogger().appendToFile("http.log"))
//                .logLevel(Logger.Level.FULL)
                .target(ShopifyApiClient.class, myShopifyUrl);
    }
}
