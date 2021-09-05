package me.littlelenim.simplestudentteachercrud.service;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.StudentDTO;
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
    public void addNewStudent(StudentDTO dto){
        Student student = new Student(dto);
        studentRepository.save(student);
    }
}
