package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TransactionList
{
    @JsonProperty(value = JsonConstants.TRANSACTIONS)
    private List<Transaction> transactions;
}
