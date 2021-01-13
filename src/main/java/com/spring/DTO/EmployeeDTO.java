package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.model.Passport;
import com.spring.model.Position;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    @JsonProperty("employee_id")
    private Long id;

    @NotBlank
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("address")
    private AddressDTO address;

    @NotNull
    @JsonProperty("number_inn")
    private Integer numberINN;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    @JsonProperty("date_birth")
    private LocalDate dateBirth;

    @NotBlank
    private String gender;

    @NotNull
    private PositionDTO position;

    @NotNull
    @JsonProperty("subdivision_id")
    private Long subdivisionId;

    private String status;

    @NotNull
    private PassportDTO passport;

    @JsonProperty("vacation_start")
    private LocalDate vacationStart;

    @JsonProperty("vacation_final")
    private LocalDate vacationFinal;

    @JsonProperty("work_agreement")
    private Boolean workAgreement;
}
