package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    @JsonProperty("user_id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("second_name")
    private String secondName;

    private AddressDTO address;

    @JsonProperty("number_inn")
    private Integer numberINN;

    private String email;

    private String phone;

    @JsonProperty("date_birth")
    private LocalDate dateBirth;

    private String gender;

    private PositionDTO position;

    @JsonProperty("subdivision_id")
    private Long subdivisionId;

    private List<StoreDTO> stores = new ArrayList<>();

    private PassportDTO passport;

    @JsonProperty("vacation_start")
    private LocalDate vacationStart;

    @JsonProperty("vacation_final")
    private LocalDate vacationFinal;

    private String password;

    private String role;

    @JsonProperty("name_firm")
    private String nameFirm;
}
