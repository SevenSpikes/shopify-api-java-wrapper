package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Product
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.TITLE)
    private String title;

    @JsonProperty(value = JsonConstants.HANDLE)
    private String handle;

    @JsonProperty(value = JsonConstants.IMAGE)
    private Image featuredImage;

    @JsonProperty(value = JsonConstants.PRODUCT_VARIANTS)
    private List<ProductVariant> productVariants;
}
