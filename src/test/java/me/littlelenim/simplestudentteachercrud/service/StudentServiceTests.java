package me.littlelenim.simplestudentteachercrud.service;

import me.littlelenim.simplestudentteachercrud.dto.GradeDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentDTO;
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
    public void addStudentTest(){
        StudentDTO dto = new StudentDTO("John", "Smith");
        studentService.addNewStudent(dto);
    }
    @Test
    @Transactional
    public void addGradeToStudentTest(){
        StudentDTO dto = new StudentDTO("John", "Smith");
        studentService.addNewStudent(dto);

        GradeDTO gradeDTO = new GradeDTO(5,2,"Math exam");
        Student student = studentService.getAllStudents().get(0);
        studentService.addGradeByStudentId(student.getId(),gradeDTO);
        System.out.println("student = " + student);
        Assertions.assertNotEquals(0,student.getGrades().size(),"Grades should not be empty!");
    }
    @AfterEach
    public void clearStudentRepository(){
        studentRepository.deleteAll();
        studentRepository.flush();
    }
}
