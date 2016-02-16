package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Webhook
{
    @JsonProperty(value = JsonConstants.WEBHOOK)
    private WebhookContent webhookContent;
}
