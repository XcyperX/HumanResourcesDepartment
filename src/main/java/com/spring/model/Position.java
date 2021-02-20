package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "positions")
@Data
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private PositionName positionName;

    private LocalDate dateReceipt;

    private LocalDate dateDismissal;

    @OneToOne(mappedBy = "position")
    private User user;

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
