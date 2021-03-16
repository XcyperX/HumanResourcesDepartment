package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
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

    //    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private Customer customer;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name = "order_product", joinColumns = {@JoinColumn(name = "order_id")}, inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> productList = new ArrayList<>();

    @OneToMany(mappedBy = "orderHistory", cascade = CascadeType.ALL)
    private List<OrderProductInfo> orderProductInfos = new ArrayList<>();

    private Status status;

    private Float price;

    private LocalDate dateOrder;

    private LocalDate dateReception;
}
