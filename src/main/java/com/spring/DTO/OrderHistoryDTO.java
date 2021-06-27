package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderHistoryDTO implements Serializable {
    @JsonProperty("order_history_id")
    private Long id;

//    @JsonProperty("customer_id")
//    private Long customerId;

    private CustomerDTO customer;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("provider_id")
    private Long providerId;

    @JsonProperty("date_order")
    private LocalDate dateOrder;

    @JsonProperty("date_reception")
    private LocalDate dateReception;

//    @JsonProperty("product_list")
//    private List<ProductDTO> productList = new ArrayList<>();

    @JsonProperty("product_info_list")
    private List<OrderProductInfoDTO> orderProductInfoDTOS = new ArrayList<>();

    private String status;

    private Double price;
}
