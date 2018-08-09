package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VariantOption {

    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.OPTION_NAME)
    private String name;

    @JsonProperty(value = JsonConstants.OPTION_POSITION)
    private int position;

    @JsonProperty(value = JsonConstants.OPTION_VALUES)
    private List<String> values;
}
