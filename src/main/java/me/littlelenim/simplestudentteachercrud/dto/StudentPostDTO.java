package me.littlelenim.simplestudentteachercrud.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class StudentPostDTO {
    @NotBlank
    @Size(min = 2, max = 35)
    private String firstName;

    @Size(min = 2, max = 35)
    @NotBlank
    private String lastName;
}
