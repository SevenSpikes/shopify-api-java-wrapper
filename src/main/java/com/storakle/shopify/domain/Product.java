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
public class Product
{
    @JsonProperty(value = JsonConstants.ID)
    private long id;

    @JsonProperty(value = JsonConstants.TITLE)
    private String title;

    @JsonProperty(value = JsonConstants.HANDLE)
    private String handle;

    @JsonProperty(value = JsonConstants.IMAGE)
    private Image featuredImage;

    @JsonProperty(value = JsonConstants.IMAGES)
    private List<Image> images;

    @JsonProperty(value = JsonConstants.PUBLISHED_AT)
    @JsonDeserialize(using = FlexDateDeserializer.class)
    @JsonSerialize(using = FlexDateSerializer.class)
    private Date publishedAt;

    @JsonProperty(value = JsonConstants.PRODUCT_VARIANTS)
    private List<ProductVariant> productVariants;

    @JsonProperty(value = JsonConstants.PRODUCT_VARIANT_OPTIONS)
    private List<VariantOption> variantOptions;
}
