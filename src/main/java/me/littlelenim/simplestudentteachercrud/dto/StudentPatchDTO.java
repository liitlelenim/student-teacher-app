package me.littlelenim.simplestudentteachercrud.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPatchDTO {
    @Size(min = 2, max = 35)
    private String firstName;

    @Size(min = 2, max = 35)
    private String lastName;
}
