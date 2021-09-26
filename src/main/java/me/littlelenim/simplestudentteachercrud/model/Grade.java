package me.littlelenim.simplestudentteachercrud.model;


import me.littlelenim.simplestudentteachercrud.dto.GradePostDTO;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "grade")
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

    public Grade() {

    }

    public Grade(int value, int weight, String description) {
        this.value = value;
        this.weight = weight;
        this.description = description;
    }

    public Grade(GradePostDTO dto) {
        this.value = dto.getValue();
        this.weight = dto.getWeight();
        this.description = dto.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade grade)) return false;
        return getValue() == grade.getValue() && getWeight() == grade.getWeight() && getId().equals(grade.getId()) && getDescription().equals(grade.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getWeight(), getDescription());
    }
}
