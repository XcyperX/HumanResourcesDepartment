package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PositionNameDTO implements Serializable {
    @JsonProperty("position_name_id")
    private Long id;

    private String name;
}
