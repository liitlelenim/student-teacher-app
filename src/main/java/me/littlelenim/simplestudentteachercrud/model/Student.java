package me.littlelenim.simplestudentteachercrud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.littlelenim.simplestudentteachercrud.dto.StudentPostDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student
{
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "grades_id",
            referencedColumnName = "id"
    )
    private List<Grade> grades;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Student(StudentPostDTO dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
    }
    public void addGrade(Grade grade){
        if(grades == null){
            grades = new ArrayList<>();
        }
        grades.add(grade);
    }

}
