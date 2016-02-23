package com.storakle.shopify;

import com.storakle.shopify.domain.*;
import feign.Param;
import feign.RequestLine;

public interface ShopifyApiClient
{
    int MAXIMUM_RETURNED_RESULTS = 250;

    @RequestLine("GET /admin/customers.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    CustomerList getCustomers(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/customers/count.json")
    Count getCustomersCount();

    @RequestLine("GET /admin/custom_collections.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    CustomCollectionList getCustomCollections(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/custom_collections/count.json")
    Count getCustomCollectionsCount();

    @RequestLine("GET /admin/smart_collections.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    SmartCollectionList getSmartCollections(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/smart_collections/count.json")
    Count getSmartCollectionsCount();

    @RequestLine("GET /admin/products.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    ProductList getProducts(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/products/count.json")
    Count getProductsCount();

    @RequestLine("GET /api/collects?limit={limit}&page={page}&fields={fields}")
    CollectList getCollects(@Param("limit") Integer limit, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/collects/count.json")
    Count getCollectsCount();

    @RequestLine("GET /admin/orders.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    OrderList getOrders(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/orders/count.json")
    Count getOrdersCount();

    @RequestLine("GET /admin/webhooks.json")
    WebhookList getWebhooks();

    @RequestLine("POST /admin/webhooks.json")
    Webhook createWebhook(Webhook webhook);
}
