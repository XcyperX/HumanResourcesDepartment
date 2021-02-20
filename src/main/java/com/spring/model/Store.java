package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
@Data
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplies supplies;

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "stores")
    @ManyToMany
    @JoinTable(name = "user_store", joinColumns = {@JoinColumn(name = "store_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "stores")
    private List<User> users = new ArrayList<>();

    private Boolean isProvide;

    public Store() {
    }

    public Store(Long id) {
        this.id = id;
    }
}
