package me.littlelenim.simplestudentteachercrud.service;

import lombok.AllArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.GradePatchDTO;
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
    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }

    @Transactional
    public void patchGrade(Long id, GradePatchDTO dto) {
        Grade grade = getById(id);

        if (dto.getValue() != null) {
            grade.setValue(dto.getValue());
        }
        if (dto.getWeight() != null) {
            grade.setWeight(dto.getWeight());
        }
        if (dto.getDescription() != null) {
            grade.setDescription(dto.getDescription());
        }
    }
    @Transactional
    public Grade getById(Long id){
        return gradeRepository.findById(id).orElseThrow(() -> {
            throw new InvalidIdException("There's no grade with id: " + id + ".");
        });
    }

}
