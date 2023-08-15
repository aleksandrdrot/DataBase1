package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int minAge, int maxAge);

    Collection<Student> findStudentsByFacultyIgnoreCase_name(String str);

    @Query(value = "select count(student) from student", nativeQuery = true)
    Integer countAllStudent();

    @Query(value = "select AVG(age) from student", nativeQuery = true)
    Integer avgAgeStudent();

    @Query(value = "select id, name from student order by id desc LIMIT 5", nativeQuery = true)
    List<countStudent> idSortStudent();

}
