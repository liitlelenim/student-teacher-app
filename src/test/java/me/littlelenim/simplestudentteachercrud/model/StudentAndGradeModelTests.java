package me.littlelenim.simplestudentteachercrud.model;

import me.littlelenim.simplestudentteachercrud.repository.GradeRepository;
import me.littlelenim.simplestudentteachercrud.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentAndGradeModelTests {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GradeRepository gradeRepository;

    @Test
    public void studentModelTest(){
        Student testStudent = new Student("John", "Smith");
        Assertions.assertNotNull(testStudent,"Created student should not be null!");
        studentRepository.save(testStudent);

        Grade testGrade = new Grade(5,2,"Math exam");
        Assertions.assertNotNull(testGrade,"Created grade should not be null!");

        testStudent.addGrade(testGrade);
        Assertions.assertNotNull(testStudent.getGrades(),"Student grades should not be null" +
                "after this operation");

        System.out.println("testStudent = " + testStudent);
    }
}
