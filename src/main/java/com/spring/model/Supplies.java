package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplies")
@Data
public class Supplies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOrder;

    private LocalDate dateReception;

    @OneToMany(mappedBy = "supplies", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Supplies(Long id) {
        this.id = id;
    }
}
