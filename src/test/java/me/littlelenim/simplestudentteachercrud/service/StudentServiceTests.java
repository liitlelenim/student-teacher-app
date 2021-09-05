package me.littlelenim.simplestudentteachercrud.service;

import me.littlelenim.simplestudentteachercrud.dto.StudentDTO;
import me.littlelenim.simplestudentteachercrud.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTests {


    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void addStudentTest(){
        StudentDTO dto = new StudentDTO("John", "Smith");
        studentService.addNewStudent(dto);
    }

    @AfterEach
    public void clearStudentRepository(){
        studentRepository.deleteAll();
        studentRepository.flush();
    }
}
