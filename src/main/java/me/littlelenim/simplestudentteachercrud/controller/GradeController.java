package me.littlelenim.simplestudentteachercrud.controller;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradeDTO;
import me.littlelenim.simplestudentteachercrud.model.Grade;
import me.littlelenim.simplestudentteachercrud.service.GradeService;
import me.littlelenim.simplestudentteachercrud.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @GetMapping("/grade/{id}/info")
    public Grade getGrade(@PathVariable("id") Long id){
        return gradeService.getGradeById(id);
    }
    @PatchMapping("/grade/{id}/patch")
    public void patchGrade(@PathVariable("id") Long id,@RequestBody GradeDTO gradeDTO){
        gradeService.patchGrade(id,gradeDTO);
    }

}
