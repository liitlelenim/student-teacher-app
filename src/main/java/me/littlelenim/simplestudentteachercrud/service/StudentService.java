package me.littlelenim.simplestudentteachercrud.service;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradePostDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentPatchDTO;
import me.littlelenim.simplestudentteachercrud.dto.StudentPostDTO;
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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void addNewStudent(StudentPostDTO dto) {
        Student student = new Student(dto);
        studentRepository.save(student);
    }

    @Transactional
    public void addGradeByStudentId(Long studentId, GradePostDTO gradePostDTO) {
        Student student = getStudentById(studentId);

        Grade grade = new Grade(gradePostDTO);

        student.addGrade(grade);
        studentRepository.save(student);
    }

    @Transactional
    public void patchStudent(Long studentId, StudentPatchDTO dto) {
        Student student = getStudentById(studentId);

        if (dto.getFirstName() != null) {
            student.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            student.setLastName(dto.getLastName());
        }
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> {
            throw new InvalidIdException("There's no student with id: " + studentId + ".");
        });
    }
}
