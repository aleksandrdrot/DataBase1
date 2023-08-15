package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.join;

@Service
public class FacultyService {

    Logger log = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        log.info("createFaculty = OK!");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        log.info("findFaculty = OK!");
        return facultyRepository.findById(id).get();
    }

    public Faculty changeFaculty(Faculty faculty) {
        log.info("changeFaculty = OK!");
        return facultyRepository.save(faculty);
    }

    public void removeFaculty(long id) {
        facultyRepository.deleteById(id);
        log.info("removeFaculty = OK!");
    }

    public Collection<Faculty> allFaculty() {
        log.info("allFaculty = OK!");
        return facultyRepository.findAll();
    }

    public String longNameFaculty() {
        return facultyRepository.findAll().stream()
                .map(Faculty::getName)
                .max(Comparator.comparing(f -> f.length()))
                .orElse(null);
    }

    public List<Integer> iterate() {
        List<Integer> ls = new ArrayList<>();

        long start1 = System.currentTimeMillis();

        int sum1 = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);

        long finish1 = System.currentTimeMillis();
        long elapsed1 = finish1 - start1;
        System.out.println("Прошло времени1, нс: " + elapsed1);
        ls.add(sum1);


        // Вариант с обычным циклом намного быстрее //
        long start2 = System.currentTimeMillis();

        int sum2 = 0;
        for (int a = 1; a <= 1000000; a++) {
            sum2 += a;
        }

        long finish2 = System.currentTimeMillis();
        long elapsed2 = finish2 - start2;
        System.out.println("Прошло времени2, нс: " + elapsed2);
        ls.add(sum2);
        return ls;
    }

    public Collection<Faculty> findFacultiesByNameOrColor(String name, String color) {
        log.info("findFacultiesByNameOrColor = OK!");
        return facultyRepository.findFacultiesByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }

    public Faculty findFacultiesByStudent(String name) {
        log.info("findFacultiesByStudent = OK!");
        return facultyRepository.findFacultiesByStudentsIgnoreCase_name(name);
    }
}
