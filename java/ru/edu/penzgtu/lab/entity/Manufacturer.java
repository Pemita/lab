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
@Entity //Сущность связанная с таблицей в базе данных
@Table(name = "manufacturers")
public class Manufacturer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "manufacturers_gpus",
            joinColumns = @JoinColumn(name = "gpu_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    )
    private List<GPU> gpus;
}