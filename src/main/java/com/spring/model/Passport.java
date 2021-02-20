package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passports")
@Data
public class Passport implements Serializable {
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

    @OneToOne(mappedBy = "passport")
    private User user;

    public Passport() {
    }

    public Passport(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                '}';
    }
}
