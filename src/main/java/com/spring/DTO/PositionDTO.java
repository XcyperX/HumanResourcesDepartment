package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PositionDTO implements Serializable {
    @JsonProperty("position_id")
    private Long id;

    @JsonProperty("position_name_id")
    private Long positionNameId;

    @JsonProperty("date_receipt")
    private LocalDate dateReceipt;

    @JsonProperty("date_dismissal")
    private LocalDate dateDismissal;
}
