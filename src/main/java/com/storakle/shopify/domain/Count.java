package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Count
{
    @JsonProperty(value = JsonConstants.COUNT)
    private int count;
}
