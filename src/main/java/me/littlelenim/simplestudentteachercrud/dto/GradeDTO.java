package me.littlelenim.simplestudentteachercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeDTO {
    private int value=-1;
    private int weight=-1;
    private String description="";

    public GradeDTO(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

}
