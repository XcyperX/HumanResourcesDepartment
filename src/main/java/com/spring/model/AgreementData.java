package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "agreement_data")
@Data
public class AgreementData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subdivision_id", referencedColumnName = "id")
    private Subdivision subdivision;

    @Column(nullable = false)
    private LocalDate start;

    @Column(nullable = false)
    private LocalDate finish;

    @Column(nullable = false)
    private Payment payment;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Float sumTax;

    @Column(nullable = false)
    private String deductionCode;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Override
    public String toString() {
        return "AgreementData{}";
    }
}
