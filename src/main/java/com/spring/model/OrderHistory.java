package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_history")
@Data
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateOrder;

    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name = "order_product", joinColumns = {@JoinColumn(name = "order_id")}, inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> productList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "tables_id", referencedColumnName = "id")
    private Tables tables;

    @Column(nullable = false)
    private Float price;

    @Override
    public String toString() {
        return "OrderHistory{}";
    }
}
