package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subdivisions")
@Data
public class Subdivision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "subdivision")
    private List<User> users = new ArrayList<>();

    public Subdivision() {
    }

    public Subdivision(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Subdivision{" +
                "id=" + id +
                '}';
    }
}