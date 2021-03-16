package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.model.OrderHistory;
import com.spring.model.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerDTO implements Serializable {
    @JsonProperty("customer_id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("second_name")
    private String secondName;

    private String email;

    private String phone;

    private AddressDTO address;

    private String role;

    //    @JsonProperty("order_histories")
//    private List<OrderHistoryDTO> orderHistories;

    @JsonProperty("order_histories")
    private OrderHistoryDTO orderHistories;
}
