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
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        log.info("createStudent = OK!");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        log.info("findStudent = OK!");
        return studentRepository.findById(id).get();
    }

    public Student changeStudent(Student student) {
        log.info("changeStudent = OK!");
        return studentRepository.save(student);
    }

    public void removeStudent(long id) {
        studentRepository.deleteById(id);
        log.info("Студент с номером ID={} удалён!", id);
    }

    public Collection<Student> allStudent() {
        var st = studentRepository.findAll();
        log.info("Вывод всех студентов");
        return st;
    }

    public List<String> studentSortedC() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .filter(s -> s.startsWith("С"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public OptionalDouble studentAverageArg() {
        return studentRepository.findAll().stream()
                .mapToInt(Student::getAge)
                .average();
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
        var st = studentRepository.findByAgeBetween(minAge, maxAge);
        log.info("Поиск студентов по возрасту от {} до {} = ОК!", minAge, maxAge);
        return st;
    }

    public Collection<Student> findStudentsByFaculty(String name) {
        var st = studentRepository.findStudentsByFacultyIgnoreCase_name(name);
        log.info("Поиск студентов по факультету = ОК!");
        return st;
    }

    public Integer countAllStudent() {
        var st = studentRepository.countAllStudent();
        log.info("countAllStudent = OK!");
        return st;
    }

    public Integer avgAgeStudent() {
        var st = studentRepository.avgAgeStudent();
        log.info("avgAgeStudent = OK!");
        return st;
    }

    public List<countStudent> idSortStudent() {
        var st = studentRepository.idSortStudent();
        log.info("idSortStudent = OK!");
        return st;
    }

    public void studentName() {
        List<String> st = studentRepository.studentName();

        System.out.println("Name1 - " + st.get(0));
        System.out.println("Name2 - " + st.get(1));

        Thread thread1 = new Thread(() -> {
            System.out.println("Name3 - " + st.get(2));
            System.out.println("Name4 - " + st.get(3));
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("Name5 - " + st.get(4));
            System.out.println("Name6 - " + st.get(5));
        });
        thread2.start();

        System.out.println("Name7 - " + st.get(6));
        System.out.println("Name8 - " + st.get(7));
        System.out.println("Name9 - " + st.get(8));
        System.out.println("Name10 - " + st.get(9));

    }

    public void studentNamePrint() {

        List<String> st = studentRepository.studentName();

        printStudentName("Name1 - " + st.get(0));
        printStudentName("Name2 - " + st.get(1));

        new Thread(() -> {
            printStudentName("Name3 - " + st.get(2));
            printStudentName("Name4 - " + st.get(3));
        }).start();


        new Thread(() -> {
            printStudentName("Name5 - " + st.get(4));
            printStudentName("Name6 - " + st.get(5));
        }).start();


        printStudentName("Name7 - " + st.get(6));
        printStudentName("Name8 - " + st.get(7));
        printStudentName("Name9 - " + st.get(8));
        printStudentName("Name10 - " + st.get(9));

    }

    public synchronized void printStudentName(String str){
        System.out.println(str);
    }

}
