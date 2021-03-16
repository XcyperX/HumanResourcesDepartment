package com.spring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_product_info")
@Data
public class OrderProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "order_history_id", referencedColumnName = "id")
    private OrderHistory orderHistory;

}
