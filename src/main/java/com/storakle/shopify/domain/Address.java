package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.EMAIL)
    private String email;

    @JsonProperty(value = JsonConstants.FIRST_NAME)
    private String firstName;

    @JsonProperty(value = JsonConstants.LAST_NAME)
    private String lastName;

    @JsonProperty(value = JsonConstants.COMPANY)
    private String company;

    @JsonProperty(value = JsonConstants.COUNTRY)
    private String country;

    @JsonProperty(value = JsonConstants.CITY)
    private String city;

    @JsonProperty(value = JsonConstants.PROVINCE)
    private String province;

    @JsonProperty(value = JsonConstants.ZIP)
    private String zip;

    @JsonProperty(value = JsonConstants.PHONE)
    private String phone;

    @JsonProperty(value = JsonConstants.ADDRESS1)
    private String address1;

    @JsonProperty(value = JsonConstants.ADDRESS2)
    private String address2;
}
