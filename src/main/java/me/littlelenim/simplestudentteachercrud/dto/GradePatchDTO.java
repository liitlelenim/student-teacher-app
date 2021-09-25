package me.littlelenim.simplestudentteachercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradePatchDTO {

    @Min(0)
    @Max(100)
    private Integer value;

    @Min(0)
    @Max(100)
    private Integer weight;

    @Size(max = 255)
    private String description;

}
