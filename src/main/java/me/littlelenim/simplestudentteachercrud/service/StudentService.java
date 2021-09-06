package me.littlelenim.simplestudentteachercrud.service;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradeDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentDTO;
import me.littlelenim.simplestudentteachercrud.model.Grade;
import me.littlelenim.simplestudentteachercrud.model.Student;
import me.littlelenim.simplestudentteachercrud.repository.GradeRepository;
import me.littlelenim.simplestudentteachercrud.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @Transactional
    public void addNewStudent(StudentDTO dto){
        Student student = new Student(dto);
        studentRepository.save(student);
    }
    @Transactional
    public void addGradeByStudentId(Long studentId, GradeDTO gradeDTO){
        Student student = getStudentById(studentId);

        Grade grade = new Grade(gradeDTO);

        student.addGrade(grade);
        studentRepository.save(student);
    }
    public Student getStudentById(Long studentId){
        return studentRepository.findById(studentId).orElseThrow(()->{
            throw new IllegalArgumentException("There's no student with id: "+studentId+".");
        });
    }
}
