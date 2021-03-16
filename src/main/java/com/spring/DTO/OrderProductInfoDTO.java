package com.spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderProductInfoDTO implements Serializable {
    @JsonProperty("product_info_id")
    private Long id;

//    @JsonProperty("product_id")
    private ProductDTO product;

    private Integer amount;

    @JsonProperty("order_history_id")
    private Long orderHistoryId;
}
