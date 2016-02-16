package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CustomerList
{
    @JsonProperty(value = JsonConstants.CUSTOMERS)
    private List<Customer> customers;
}
