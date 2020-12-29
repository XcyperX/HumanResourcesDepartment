package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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

    @NotBlank
    @JsonProperty("address")
    private AddressDTO address;

    @NotBlank
    @JsonProperty("number_inn")
    private Integer numberINN;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    @JsonProperty("date_birth")
    private String dateBirth;

    @NotBlank
    private String gender;

    @NotBlank
    @JsonProperty("position_id")
    private Long positionId;

    @NotBlank
    @JsonProperty("subdivision_id")
    private Long subdivisionId;

    @NotBlank
    @JsonProperty("status_id")
    private Long statusId;

    @NotBlank
    @JsonProperty("passport_id")
    private Long passportId;
}
