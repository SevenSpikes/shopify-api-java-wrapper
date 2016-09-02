package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SmartCollection
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.TITLE)
    private String name;

    @JsonProperty(value = JsonConstants.HANDLE)
    private String handle;
}
