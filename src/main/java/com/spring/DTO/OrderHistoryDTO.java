package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.model.Product;
import com.spring.model.Status;
import com.spring.model.Tables;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderHistoryDTO {
    @JsonProperty("order_history_id")
    private Long id;

    @NotNull
    @JsonProperty("date_order")
    private LocalDate dateOrder;

    @NotNull
    @JsonProperty("product_list")
    private List<ProductDTO> productList = new ArrayList<>();

    @NotNull
    @JsonProperty("status_id")
    private Long statusId;

    @NotNull
    @JsonProperty("tables_id")
    private Long tablesId;

    @NotNull
    private Float price;
}
