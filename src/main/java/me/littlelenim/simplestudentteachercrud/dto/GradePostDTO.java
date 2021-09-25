package me.littlelenim.simplestudentteachercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradePostDTO {

    @Min(0)
    @Max(100)
    private int value;

    @Min(0)
    @Max(100)
    private int weight;

    @Size(max = 255)
    @NotNull
    private String description;

    public GradePostDTO(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

}
