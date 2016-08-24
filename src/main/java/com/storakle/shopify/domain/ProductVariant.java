package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVariant
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.TITLE)
    private String title;

    @JsonProperty(value = JsonConstants.PRICE)
    private BigDecimal price;
}
