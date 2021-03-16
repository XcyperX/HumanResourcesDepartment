package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class PassportDTO implements Serializable {
    @JsonProperty("pas_id")
    private Long id;

    @NotBlank
    @JsonProperty("number_series")
    private Integer numberSeries;

    @NotBlank
    @JsonProperty("passport_id")
    private Integer passportId;

    @NotBlank
    @JsonProperty("issued_by")
    private String issuedBy;

    @NotBlank
    @JsonProperty("date_issue")
    private String dateIssue;

    @Override
    public String toString() {
        return numberSeries + ", " + passportId + ", " + issuedBy + ", " + dateIssue;
    }
}