package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.countStudent;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public Collection<Student> allStudent(){
        return studentService.allStudent();
    }

    @GetMapping("{id}")
    public Student findStudent(@PathVariable long id){
        return studentService.findStudent(id);
    }

    @GetMapping("age/{minAge}/{maxAge}")
    public Collection<Student> findByAgeBetween(@PathVariable int minAge,@PathVariable int maxAge){
        return studentService.findByAgeBetween(minAge, maxAge);
    }
    @GetMapping("faculty/{name}")
    public Collection<Student> findStudentsByFaculty(@PathVariable String name){
        return studentService.findStudentsByFaculty(name);
    }

    @GetMapping("count-all-student")
    public Integer countAllStudent(){
        return studentService.countAllStudent();
    }

    @GetMapping("avg-age-student")
    public Integer avgAgeStudent(){
        return studentService.avgAgeStudent();
    }

    @GetMapping("id-sort-student")
    public List<countStudent> idSortStudent(){
        return studentService.idSortStudent();
    }

    @GetMapping("sort-c")
    public Collection<String> studentSortedC(){
        return studentService.studentSortedC();
    }

    @GetMapping("average-arg")
    public OptionalDouble studentAverageArg(){
        return studentService.studentAverageArg();
    }

}
