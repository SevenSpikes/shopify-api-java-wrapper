package com.storakle.shopify.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import static feign.Util.checkNotNull;

public class OAuthRequestInterceptor implements RequestInterceptor
{
    private final String accessToken;

    /**
     * Creates an interceptor that authenticates all requests with the specified accessToken
     *
     * @param accessToken the OAuth accessToken to use for authentication
     */
    public OAuthRequestInterceptor(String accessToken)
    {
        checkNotNull(accessToken, "accessToken");
        this.accessToken = accessToken;
    }

    @Override
    public void apply(RequestTemplate template)
    {
        template.header("X-Shopify-Access-Token", accessToken);
    }
}
