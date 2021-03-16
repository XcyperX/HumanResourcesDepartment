package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderid_productid")
@Data
public class OrderIdAndProductId implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderHistory orderHistory;

    private Integer amount;
}
