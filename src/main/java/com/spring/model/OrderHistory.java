package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_history")
@Data
public class OrderHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private User provider;

    @OneToMany(mappedBy = "orderHistory", cascade = CascadeType.ALL)
    private List<OrderProductInfo> orderProductInfos = new ArrayList<>();

    private Status status;

    private Double price;

    private LocalDate dateOrder;

    private LocalDate dateReception;
}
