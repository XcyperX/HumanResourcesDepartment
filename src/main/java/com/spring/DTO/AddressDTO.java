package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AddressDTO implements Serializable {
    @JsonProperty("address_id")
    private Long id;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    private String house;

    private String flat;

    @Override
    public String toString() {
        return city + ", " + street + ", д." + house + "-" + flat;
    }

}
