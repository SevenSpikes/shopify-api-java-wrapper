package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CustomCollectionList
{
    @JsonProperty(value = JsonConstants.CUSTOM_COLLECTIONS)
    private List<CustomCollection> customCollections;
}
