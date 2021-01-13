package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.model.Employee;
import com.spring.model.Payment;
import com.spring.model.Subdivision;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AgreementDataDTO {
    @JsonProperty("agreement_id")
    private Long id;

    @NotNull
    private LocalDate start;

    @NotNull
    private LocalDate finish;

    @NotNull
    private String payment;

    private Float price;

    @JsonProperty("sum_tax")
    private Float sumTax;

    @NotBlank
    @JsonProperty("deduction_code")
    private String deductionCode;

    @NotNull
    @JsonProperty("employee_id")
    private Long employeeId;
}
