package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VacationDateDTO {
    @JsonProperty("vacation_start")
    private LocalDate vacationStart;

    @JsonProperty("vacation_final")
    private LocalDate vacationFinal;
}
