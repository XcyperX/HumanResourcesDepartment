package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "statuses")
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "status")
    private List<Employee> employees = new ArrayList<>();

    public Status() {
    }

    public Status(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                '}';
    }
}
