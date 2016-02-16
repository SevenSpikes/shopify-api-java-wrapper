package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Product
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.TITLE)
    private String title;
}
