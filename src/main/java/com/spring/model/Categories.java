package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

    public Categories() {
    }

    public Categories(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                '}';
    }
}
