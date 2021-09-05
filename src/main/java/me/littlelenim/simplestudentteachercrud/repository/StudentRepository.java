package me.littlelenim.simplestudentteachercrud.repository;

import me.littlelenim.simplestudentteachercrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
