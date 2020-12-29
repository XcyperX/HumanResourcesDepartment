package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position_names")
@Data
public class PositionName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "positionName")
    private List<Position> positions = new ArrayList<>();

    @Override
    public String toString() {
        return "PositionName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
