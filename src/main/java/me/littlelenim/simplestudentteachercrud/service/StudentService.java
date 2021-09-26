package me.littlelenim.simplestudentteachercrud.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void add(StudentPostDTO dto) {
        Student student = new Student(dto);
        studentRepository.save(student);
    }

    @Transactional
    public void addGradeByStudentId(Long studentId, GradePostDTO gradePostDTO) {
        Student student = getById(studentId);

        Grade grade = new Grade(gradePostDTO);

        student.addGrade(grade);
        studentRepository.save(student);
    }

    @Transactional
    public void patchPersonalInfo(Long studentId, StudentPatchDTO dto) {
        Student student = getById(studentId);

        if (dto.getFirstName() != null) {
            student.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            student.setLastName(dto.getLastName());
        }
    }

    public Student getById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> {
            throw new InvalidIdException("There's no student with id: " + studentId + ".");
        });
    }
}
