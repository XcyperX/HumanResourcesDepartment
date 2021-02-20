package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SuppliesDTO implements Serializable {
    @JsonProperty("supplies_id")
    private Long id;

    @JsonProperty("date_order")
    private LocalDate dateOrder;

    @JsonProperty("date_reception")
    private LocalDate dateReception;
}
