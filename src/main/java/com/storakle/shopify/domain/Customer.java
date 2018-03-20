package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.storakle.shopify.jackson.FlexDateDeserializer;
import com.storakle.shopify.jackson.FlexDateSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Customer
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.EMAIL)
    private String email;

    @JsonProperty(value = JsonConstants.FIRST_NAME)
    private String firstName;

    @JsonProperty(value = JsonConstants.LAST_NAME)
    private String lastName;

    @JsonProperty(value = JsonConstants.ACCEPTS_MARKETING)
    private Boolean acceptsMarketing;

    @JsonProperty(value = JsonConstants.CREATED_AT)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    @JsonSerialize(using = FlexDateSerializer.class)
    private Date createdAt;

    @JsonProperty(value = JsonConstants.ADDRESSES)
    private List<Address> addresses;
}
