package me.littlelenim.simplestudentteachercrud.service;

import me.littlelenim.simplestudentteachercrud.dto.GradePatchDTO;
import me.littlelenim.simplestudentteachercrud.dto.GradePostDTO;
import me.littlelenim.simplestudentteachercrud.exception.InvalidIdException;
import me.littlelenim.simplestudentteachercrud.model.Grade;
import me.littlelenim.simplestudentteachercrud.repository.GradeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GradeServiceTest {

    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private GradeService gradeService;

    private Long firstGradeId;
    @BeforeEach
    public void setUp() {
        GradePostDTO testDto = new GradePostDTO(2, 3, "WOOW");
        List<Grade> grades = new ArrayList<>();

        for(int i = 0; i <10; i++) {
            grades.add(new Grade(testDto));
        }

        gradeRepository.saveAllAndFlush(grades);

        firstGradeId = gradeRepository.findAll().get(0).getId();
    }

    @AfterEach
    public void tearDown() {
        gradeRepository.deleteAll();
        gradeRepository.flush();
    }

    @Test
    public void deleteGradeById() {
        gradeService.deleteById(firstGradeId);
        Assertions.assertThrows(InvalidIdException.class, () -> gradeService.getById(firstGradeId));
    }

    @Test
    @Transactional
    public void patchGrade() {
        String testDescription = "Hello";
        GradePatchDTO patchDto = new GradePatchDTO();
        patchDto.setDescription(testDescription);
        gradeService.patchGrade(firstGradeId,patchDto);

        Grade patchedGrade = gradeService.getById(firstGradeId);

        Assertions.assertEquals(testDescription,patchedGrade.getDescription(),"Patching should change" +
                "entity properties.");

        System.out.println("patchedGrade = " + patchedGrade);
    }
}