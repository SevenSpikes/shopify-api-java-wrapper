package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderList
{
    @JsonProperty(value = JsonConstants.ORDERS)
    private List<Order> orders;
}
