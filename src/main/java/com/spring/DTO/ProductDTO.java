package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {
    @JsonProperty("product_id")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @JsonProperty("categories_id")
    private Long categoriesId;

    @JsonProperty("manufacturer_id")
    private Long manufacturerId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("store_id")
    private Long storeId;

    @JsonProperty("supplies_id")
    private Long suppliesId;

    @JsonProperty("url_photo")
    private String urlPhoto;
    
    private Integer amount;

    private Float price;
}

