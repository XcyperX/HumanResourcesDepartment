package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position_names")
@Data
public class PositionName implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "positionName", cascade = CascadeType.ALL)
    private List<Position> positions = new ArrayList<>();

    public PositionName() {
    }

    public PositionName(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PositionName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
