package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ManufacturerDTO implements Serializable {
    @JsonProperty("manufacturer_id")
    private Long id;

    private String name;
}
