package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SmartCollectionList
{
    @JsonProperty(value = JsonConstants.SMART_COLLECTIONS)
    private List<SmartCollection> smartCollections;
}
