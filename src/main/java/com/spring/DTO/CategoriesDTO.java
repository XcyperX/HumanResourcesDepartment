package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class CategoriesDTO implements Serializable {
    @JsonProperty("categories_id")
    private Long id;

    @NotBlank
    private String name;
}
