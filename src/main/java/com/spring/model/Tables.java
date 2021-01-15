package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tables")
@Data
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "tables")
    private List<OrderHistory> orderHistories = new ArrayList<>();

    public Tables() {
    }

    public Tables(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                '}';
    }
}
