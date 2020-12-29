package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PositionNameDTO {
    @JsonProperty("position_name_id")
    private Long id;

    private String name;
}
