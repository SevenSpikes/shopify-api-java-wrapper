package com.storakle.shopify.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.storakle.shopify.jackson.FlexDateDeserializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RecurringApplicationCharge
{
    @JsonProperty(value = JsonConstants.CHARGE_ID)
    private String id;

    @JsonProperty(value = JsonConstants.TEST)
    private Boolean test;

    @JsonProperty(value = JsonConstants.PLAN_NAME)
    private String name;

    @JsonProperty(value = JsonConstants.PLAN_PRICE)
    private BigDecimal price;

    // Pending/Accepted/Declined/Active/Frozen/Canceled
    @JsonProperty(value = JsonConstants.CHARGE_STATUS)
    private String status;

    @JsonProperty(value = JsonConstants.BILLING_ON)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    private Date billingOn;

    @JsonProperty(value = JsonConstants.CREATED_AT)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    private Date createdAt;

    @JsonProperty(value = JsonConstants.UPDATED_AT)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    private Date updatedAt;

    @JsonProperty(value = JsonConstants.ACTIVATED_ON)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    private Date activatedOn;

    @JsonProperty(value = JsonConstants.TRIAL_ENDS_ON)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    private Date trialEndsOn;

    @JsonProperty(value = JsonConstants.CANCELED_ON)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    private Date canceledOn;

    @JsonProperty(value = JsonConstants.TRIAL_DAYS)
    private Long trialDays;

    @JsonProperty(value = JsonConstants.CAPPED_AMOUNT)
    private String cappedAmount;

    @JsonProperty(value = JsonConstants.BALANCE_USED)
    private BigDecimal balanceUsed;

    @JsonProperty(value = JsonConstants.BALANCE_REMAINING)
    private BigDecimal balanceRemaining;

    @JsonProperty(value = JsonConstants.RISK_LEVEL)
    private BigDecimal riskLevel;

    @JsonProperty(value = JsonConstants.RETURN_URL)
    private String returnUrl;

    @JsonProperty(value = JsonConstants.DECORATED_RETURN_URL)
    private String decoratedReturnUrl;

    @JsonProperty(value = JsonConstants.CONFIRMATION_URL)
    private String confirmationUrl;
}
