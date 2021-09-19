package me.littlelenim.simplestudentteachercrud.controller;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradeDTO;
import me.littlelenim.simplestudentteachercrud.model.Grade;
import me.littlelenim.simplestudentteachercrud.service.GradeService;
import me.littlelenim.simplestudentteachercrud.service.StudentService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @GetMapping(value = "/grade/{id}/info")
    public Grade getGrade(@PathVariable("id") Long id){
        return gradeService.getGradeById(id);
    }
    @PatchMapping(value = "/grade/{id}/patch")
    public void patchGrade(@PathVariable("id") Long id,@RequestBody GradeDTO gradeDTO){
        gradeService.patchGrade(id,gradeDTO);
    }
    @DeleteMapping( value = "/grade/{id}/delete")
    public void deleteGrade(@PathVariable Long id){
        gradeService.deleteGradeById(id);
    }


}
