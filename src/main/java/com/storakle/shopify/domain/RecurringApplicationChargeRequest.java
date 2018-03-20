package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecurringApplicationChargeRequest
{
    @JsonProperty(value = JsonConstants.RECURRING_APPLICATION_CHARGE)
    private RecurringApplicationCharge recurringApplicationCharge;
}
