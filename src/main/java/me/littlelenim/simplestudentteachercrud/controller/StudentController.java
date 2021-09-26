package me.littlelenim.simplestudentteachercrud.controller;

import com.sun.net.httpserver.Authenticator;
import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradePostDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentPatchDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentPostDTO;
import me.littlelenim.simplestudentteachercrud.model.Student;
import me.littlelenim.simplestudentteachercrud.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(produces = "application/json")
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/{id}/grades")
    public void addGradeToStudent(@RequestBody @Valid GradePostDTO gradePostDTO, @PathVariable Long id) {
        studentService.addGradeByStudentId(id, gradePostDTO);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void createStudent(@RequestBody @Valid StudentPostDTO studentPostDTO) {
        studentService.add(studentPostDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PatchMapping(value = "/{id}")
    public void patchGrade(@PathVariable Long id,@RequestBody @Valid StudentPatchDTO studentPatchDTO){
        studentService.patchPersonalInfo(id, studentPatchDTO);
    }
}
