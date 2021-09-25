package me.littlelenim.simplestudentteachercrud.controller;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradePostDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentPatchDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentPostDTO;
import me.littlelenim.simplestudentteachercrud.model.Student;
import me.littlelenim.simplestudentteachercrud.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/all-students", produces = "application/json")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/student/{id}/info", produces = "application/json")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping(value = "/student/{id}/add-grade")
    public void addGradeToStudent(@RequestBody @Valid GradePostDTO gradePostDTO, @PathVariable Long id) {
        studentService.addGradeByStudentId(id, gradePostDTO);
    }

    @PostMapping(value = "/create-student")
    public void createStudent(@RequestBody @Valid StudentPostDTO studentPostDTO) {
        studentService.addNewStudent(studentPostDTO);
    }

    @DeleteMapping(value = "/student/{id}/delete")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @PatchMapping(value = "/student/{id}/patch")
    public void patchGrade(@PathVariable("id") Long id,@RequestBody @Valid StudentPatchDTO studentPatchDTO){
        studentService.patchStudent(id, studentPatchDTO);
    }
}
