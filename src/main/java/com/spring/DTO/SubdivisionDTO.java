package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubdivisionDTO {
    @JsonProperty("subdivision_id")
    private Long id;

    private String name;
}
