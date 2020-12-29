package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subdivisions")
@Data
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "subdivision")
    private List<Employee> employees = new ArrayList<>();

    @Override
    public String toString() {
        return "Subdivision{" +
                "id=" + id +
                '}';
    }
}
