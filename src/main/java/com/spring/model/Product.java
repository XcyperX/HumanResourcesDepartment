package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product implements Serializable {
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

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "supplies_id", referencedColumnName = "id")
    private Supplies supplies;

    @Column(nullable = false)
    private String urlPhoto;

    private Integer amount;

    @Column(nullable = false)
    private Float price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE}, mappedBy = "productList")
    private List<OrderHistory> orderHistories = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<OrderProductInfo> orderProductInfos;

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
