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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private PositionName positionName;

    private LocalDate dateReceipt;

    private LocalDate dateDismissal;

    @OneToOne(mappedBy = "position")
    private Employee employees;

    public Position() {
    }

    public Position(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                '}';
    }
}
