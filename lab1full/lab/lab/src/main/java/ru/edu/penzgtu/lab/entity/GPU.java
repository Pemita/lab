package ru.edu.penzgtu.lab.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "gpus")
public class GPU {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name="characteristics")
    private String characteristic;

    @ManyToMany(mappedBy = "gpus")
    private List<Manufacturer> manufacturers;
}