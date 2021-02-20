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

    @JsonProperty("customer_id")
    private Long customerId;

    @JsonProperty("user_id")
    private Long userId;

    @NotNull
    @JsonProperty("date_order")
    private LocalDate dateOrder;

    @JsonProperty("date_reception")
    private LocalDate dateReception;

    @NotNull
    @JsonProperty("product_list")
    private List<ProductDTO> productList = new ArrayList<>();

    @NotNull
    @JsonProperty("status_id")
    private Long statusId;

    @NotNull
    private Float price;
}
