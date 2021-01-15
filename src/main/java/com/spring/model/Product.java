package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private Categories categories;

    @Column(nullable = false)
    private String structure;

    @Column(nullable = false)
    private String urlPhoto;

    @Column(nullable = false)
    private Float price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE}, mappedBy = "productList")
    private List<OrderHistory> orderHistories = new ArrayList<>();

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }
}
