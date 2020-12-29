package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passports")
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numberSeries;

    @Column(nullable = false)
    private Integer passportId;

    @Column(nullable = false)
    private String issuedBy;

    @Column(nullable = false)
    private String dateIssue;

    @OneToMany(mappedBy = "passport")
    private List<Employee> employees = new ArrayList<>();

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                '}';
    }
}
