package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SubdivisionDTO implements Serializable {
    @JsonProperty("subdivision_id")
    private Long id;

    private String name;
}
