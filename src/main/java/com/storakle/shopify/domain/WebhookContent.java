package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.storakle.shopify.jackson.FlexDateDeserializer;
import lombok.Data;

import java.util.Date;

@Data
public class WebhookContent
{
    @JsonProperty(value = JsonConstants.ID)
    private Long id;

    @JsonProperty(value = JsonConstants.TOPIC)
    private String topic;

    @JsonProperty(value = JsonConstants.ADDRESS)
    private String address;

    @JsonProperty(value = JsonConstants.FORMAT)
    private String format;

    @JsonProperty(value = JsonConstants.CREATED_AT)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    private Date createdAt;
}
