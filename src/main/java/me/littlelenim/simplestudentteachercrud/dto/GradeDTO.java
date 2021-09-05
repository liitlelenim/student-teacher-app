package me.littlelenim.simplestudentteachercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GradeDTO {
    private int value;
    private int weight;
    private String description;

    public GradeDTO(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

}
