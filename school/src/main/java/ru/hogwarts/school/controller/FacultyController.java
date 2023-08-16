package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;


import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping()
    public Collection<Faculty> allFaculty() {
        return facultyService.allFaculty();
    }

    @GetMapping("{id}")
    public Faculty findFaculty(@PathVariable long id) {
        return facultyService.findFaculty(id);
    }

    @GetMapping("{name}/{color}")
    public Collection<Faculty> findFacultiesByNameOrColor(@PathVariable String name, @PathVariable String color) {
        return facultyService.findFacultiesByNameOrColor(name, color);
    }

    @GetMapping("student/{name}")
    public Faculty findFacultiesByStudent(@PathVariable String name) {
        return facultyService.findFacultiesByStudent(name);
    }

    @GetMapping("long-name-faculty")
    public String longNameFaculty() {
        return facultyService.longNameFaculty();
    }

    @GetMapping("iterate")
    public List<Integer> iterate() {
        return facultyService.iterate();
    }
}
