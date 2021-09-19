package me.littlelenim.simplestudentteachercrud.service;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradeDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentDTO;
import me.littlelenim.simplestudentteachercrud.exception.InvalidIdException;
import me.littlelenim.simplestudentteachercrud.model.Grade;
import me.littlelenim.simplestudentteachercrud.model.Student;
import me.littlelenim.simplestudentteachercrud.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Transactional
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
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
    @Transactional
    public void patchStudent(Long studentId, StudentDTO dto){
        Student student = getStudentById(studentId);

        if(dto.getFirstName().length()>0){
            student.setFirstName(dto.getFirstName());
        }
        if(dto.getLastName().length()>0){
            student.setLastName(dto.getLastName());
        }
    }
    public Student getStudentById(Long studentId){
        return studentRepository.findById(studentId).orElseThrow(()->{
            throw new InvalidIdException("There's no student with id: "+studentId+".");
        });
    }
}
