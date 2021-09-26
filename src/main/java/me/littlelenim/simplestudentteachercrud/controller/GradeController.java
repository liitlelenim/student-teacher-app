package me.littlelenim.simplestudentteachercrud.controller;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradePatchDTO;
import me.littlelenim.simplestudentteachercrud.model.Grade;
import me.littlelenim.simplestudentteachercrud.service.GradeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/grades")
@AllArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @GetMapping(value = "/{id}")
    public Grade getGrade(@PathVariable Long id) {
        return gradeService.getById(id);
    }

    @PatchMapping(value = "/{id}")
    public void patchGrade(@PathVariable Long id, @RequestBody @Valid GradePatchDTO gradePatchDTO) {
        gradeService.patchGrade(id, gradePatchDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteById(id);
    }


}
