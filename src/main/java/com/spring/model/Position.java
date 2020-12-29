package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "positions")
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private PositionName positionName;

    private LocalDate dateReceipt;

    private LocalDate dateDismissal;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees = new ArrayList<>();

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                '}';
    }
}
