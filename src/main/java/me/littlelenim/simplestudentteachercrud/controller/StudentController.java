package me.littlelenim.simplestudentteachercrud.controller;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradeDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentDTO;
import me.littlelenim.simplestudentteachercrud.model.Student;
import me.littlelenim.simplestudentteachercrud.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void addGradeToStudent(@RequestBody GradeDTO gradeDTO, @PathVariable Long id) {
        studentService.addGradeByStudentId(id, gradeDTO);
    }

    @PostMapping(value = "/create-student")
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addNewStudent(studentDTO);
    }

    @DeleteMapping(value = "/student/{id}/delete")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

}
