package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WebhookList
{
    @JsonProperty(value = JsonConstants.WEBHOOKS)
    private List<WebhookContent> webhooks;
}
