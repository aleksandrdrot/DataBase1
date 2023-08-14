package ru.hogwarts.school.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.repository.countStudent;

import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class StudentService {

    Logger log = LoggerFactory.getLogger(StudentService.class);
   private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        log.info( "createStudent = OK!");
        return studentRepository.save(student);
    }

    public Student findStudent(long id){
        log.info( "findStudent = OK!");
        return studentRepository.findById(id).get();
    }

    public Student changeStudent(Student student){
        log.info( "changeStudent = OK!");
        return studentRepository.save(student);
    }

    public void removeStudent(long id){
        studentRepository.deleteById(id);
        log.info( "Студент с номером ID={} удалён!", id);
    }

    public Collection<Student> allStudent(){
        var st = studentRepository.findAll();
        log.info( "Вывод всех студентов");
        return st;
    }

    public List<String> studentSortedC(){
        return studentRepository.findAll().stream()
                .filter(s -> s.getName().startsWith("С"))
                .map(student -> student.getName())
                .sorted()
                .collect(Collectors.toList());
    }

    public OptionalDouble studentAverageArg(){
        return studentRepository.findAll().stream()
                .mapToInt(Student :: getAge)
                .average();
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge){
        var st = studentRepository.findByAgeBetween(minAge, maxAge);
        log.info("Поиск студентов по возрасту от {} до {} = ОК!", minAge, maxAge);
        return st;
    }

    public Collection<Student> findStudentsByFaculty(String name){
        var st = studentRepository.findStudentsByFacultyIgnoreCase_name(name);
        log.info("Поиск студентов по факультету = ОК!");
        return st;
    }

    public Integer countAllStudent(){
        var st = studentRepository.countAllStudent();
        log.info("countAllStudent = OK!");
        return st;
    }

    public Integer avgAgeStudent(){
        var st = studentRepository.avgAgeStudent();
        log.info("avgAgeStudent = OK!");
        return st;
    }

    public List<countStudent> idSortStudent(){
        var st = studentRepository.idSortStudent();
        log.info("idSortStudent = OK!");
        return st;
    }

}
