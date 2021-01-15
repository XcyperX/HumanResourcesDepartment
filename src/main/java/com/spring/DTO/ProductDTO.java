package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;

@Data
@NoArgsConstructor
public class ProductDTO {
    @JsonProperty("product_id")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @JsonProperty("categories_id")
    private Long categoriesId;

    @NotBlank
    private String structure;

    @NotBlank
    @JsonProperty("url_photo")
    private String urlPhoto;

    @JsonProperty("image_photo")
    private File imagePhoto;

    @NotNull
    private Float price;
}
