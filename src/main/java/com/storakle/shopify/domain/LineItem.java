package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LineItem
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.PRODUCT_ID)
    private long productId;

    @JsonProperty(value = JsonConstants.PRODUCT_EXISTS)
    private boolean productExists;

    @JsonProperty(value = JsonConstants.VARIANT_ID)
    private long variantId;

    @JsonProperty(value = JsonConstants.TITLE)
    private String title;

    @JsonProperty(value = JsonConstants.NAME)
    private String name;

    @JsonProperty(value = JsonConstants.VARIANT_TITLE)
    private String variantTitle;

    @JsonProperty(value = JsonConstants.QUANTITY)
    private int quantity;

    @JsonProperty(value = JsonConstants.PRICE)
    private BigDecimal price;
}
