package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping("faculty")
public class FacultyAdminController {
    private final FacultyService facultyService;

    public FacultyAdminController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping()
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping()
    public Faculty changeFaculty(Faculty faculty) {
        return facultyService.changeFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public void removeFaculty(@PathVariable long id) {
        facultyService.removeFaculty(id);
    }

}
