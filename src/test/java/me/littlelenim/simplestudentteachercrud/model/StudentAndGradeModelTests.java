package me.littlelenim.simplestudentteachercrud.model;

import me.littlelenim.simplestudentteachercrud.dto.GradePostDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentPostDTO;
import me.littlelenim.simplestudentteachercrud.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentAndGradeModelTests {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    public void clearStudentRepository() {
        studentRepository.deleteAll();
        studentRepository.flush();
    }

    @Test
    public void studentAndGradeConstructorsShouldWork() {
        Student testStudent = new Student("John", "Smith");
        Assertions.assertNotNull(testStudent, "Created student should not be null!");
        studentRepository.save(testStudent);

        Grade testGrade = new Grade(5, 2, "Math exam");
        Assertions.assertNotNull(testGrade, "Created grade should not be null!");

        testStudent.addGrade(testGrade);
        Assertions.assertNotNull(testStudent.getGrades(), "Student grades should not be null" +
                "after this operation");

        System.out.println("testStudent = " + testStudent);
    }

    @Test
    public void studentAndGradeConstructorsShouldWorkWithDTO() {
        StudentPostDTO testStudentPostDTO = new StudentPostDTO("John", "Smith");
        Student testStudent = new Student(testStudentPostDTO);
        Assertions.assertNotNull(testStudent, "Student created from dto should not be null!");

        GradePostDTO testGradePostDTO = new GradePostDTO(5, 2);
        Grade testGrade = new Grade(testGradePostDTO);
        Assertions.assertNotNull(testGradePostDTO, "Grade created from dto should not be null!");
    }

}
