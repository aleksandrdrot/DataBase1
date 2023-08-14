package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentAdminController {

        private final StudentService studentService;

        public StudentAdminController(StudentService studentService) {
            this.studentService = studentService;
        }

        @PostMapping()
        public Student addStudent(Student student){
            return studentService.createStudent(student);
        }

        @PutMapping()
        public Student changeStudent(Student student){
            return studentService.changeStudent(student);
        }

        @DeleteMapping("{id}")
        public void removeStudent(@PathVariable long id){
            studentService.removeStudent(id);
        }

}
