package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class StoreDTO implements Serializable {
    @JsonProperty("store_id")
    private Long id;

    private String name;

    private SuppliesDTO supplies;

    private List<UserDTO> users = new ArrayList<>();

    private List<ProductDTO> products = new ArrayList<>();

    @JsonProperty("is_provide")
    private Boolean isProvide;
}
