package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.storakle.shopify.jackson.FlexDateDeserializer;
import com.storakle.shopify.jackson.FlexDateSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Transaction
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.ORDER_ID)
    private long orderId;

    @JsonProperty(value = JsonConstants.AMOUNT)
    private BigDecimal amount;

    @JsonProperty(value = JsonConstants.KIND)
    private String kind;

    @JsonProperty(value = JsonConstants.STATUS)
    private String status;

    @JsonProperty(value = JsonConstants.CREATED_AT)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    @JsonSerialize(using = FlexDateSerializer.class)
    private Date createdAt;

    @JsonProperty(value = JsonConstants.CURRENCY)
    private String currency;
}
