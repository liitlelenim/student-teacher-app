package me.littlelenim.simplestudentteachercrud.repository;

import me.littlelenim.simplestudentteachercrud.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {
}
