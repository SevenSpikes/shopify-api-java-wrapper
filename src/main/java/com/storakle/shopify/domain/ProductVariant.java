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

    @JsonProperty(value = JsonConstants.COMPARE_AT_PRICE)
    private BigDecimal compareAtPrice;

    @JsonProperty(value = JsonConstants.OPTION_1)
    private String option1;

    @JsonProperty(value = JsonConstants.OPTION_2)
    private String option2;

    @JsonProperty(value = JsonConstants.OPTION_3)
    private String option3;
}
