package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Image
{
    @JsonProperty(value = JsonConstants.SRC)
    private String src;
}
