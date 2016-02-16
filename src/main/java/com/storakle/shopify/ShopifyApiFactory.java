package com.storakle.shopify;

import com.storakle.shopify.auth.OAuthRequestInterceptor;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class ShopifyApiFactory
{
    public static ShopifyApiClient create(String accessToken, String myShopifyUrl)
    {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .requestInterceptor(new OAuthRequestInterceptor(accessToken))
                .target(ShopifyApiClient.class, myShopifyUrl);
    }
}
