package me.littlelenim.simplestudentteachercrud.service;

import me.littlelenim.simplestudentteachercrud.dto.GradePostDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentPostDTO;
import me.littlelenim.simplestudentteachercrud.model.Student;
import me.littlelenim.simplestudentteachercrud.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class StudentServiceTests {


    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void addingNewStudentsShouldWork() {
        StudentPostDTO dto = new StudentPostDTO("John", "Smith");
        studentService.add(dto);
    }

    @Test
    @Transactional
    public void addingGradesToStudentShouldWork() {
        StudentPostDTO dto = new StudentPostDTO("John", "Smith");
        studentService.add(dto);

        GradePostDTO gradePostDTO = new GradePostDTO(5, 2, "Math exam");
        Student student = studentService.getAll().get(0);
        studentService.addGradeByStudentId(student.getId(), gradePostDTO);
        Assertions.assertNotEquals(0, student.getGrades().size(), "Grades should not be empty!");
    }

    @AfterEach
    public void clearStudentRepository() {
        studentRepository.deleteAll();
        studentRepository.flush();
    }
}
