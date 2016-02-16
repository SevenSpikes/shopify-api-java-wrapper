package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.storakle.shopify.jackson.FlexDateDeserializer;
import com.storakle.shopify.jackson.FlexDateSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Order
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.TOTAL_PRICE)
    private BigDecimal totalPrice;

    @JsonProperty(value = JsonConstants.FINANCIAL_STATUS)
    private String financialStatus;

    @JsonProperty(value = JsonConstants.CUSTOMER)
    private Customer customer;

    @JsonProperty(value = JsonConstants.LINE_ITEMS)
    private List<LineItem> lineItems;

    @JsonProperty(value = JsonConstants.CREATED_AT)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    @JsonSerialize(using = FlexDateSerializer.class)
    private Date createdAt;
}
