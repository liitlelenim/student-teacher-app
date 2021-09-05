package me.littlelenim.simplestudentteachercrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "grade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

    @SequenceGenerator(
            name = "grade_sequence",
            sequenceName = "grade_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "grade_sequence"
    )
    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "value", nullable = false)
    private int value;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "description")
    private String description;
}
