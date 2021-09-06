package me.littlelenim.simplestudentteachercrud.service;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradeDTO;
import me.littlelenim.simplestudentteachercrud.exception.InvalidIdException;
import me.littlelenim.simplestudentteachercrud.model.Grade;
import me.littlelenim.simplestudentteachercrud.repository.GradeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    @Transactional
    public void deleteGradeById(Long id) {
        gradeRepository.deleteById(id);
    }

    @Transactional
    public void patchGrade(Long id, GradeDTO dto) {
        Grade grade = gradeRepository.findById(id).orElseThrow(() -> {
            throw new InvalidIdException("There's no grade with id: " + id + ".");
        });

        if (dto.getValue() != -1) {
            grade.setValue(dto.getValue());
        }
        if (dto.getWeight() != -1) {
            grade.setWeight(dto.getWeight());
        }
        if (dto.getDescription().length() != 0) {
            grade.setDescription(dto.getDescription());
        }
    }

}
