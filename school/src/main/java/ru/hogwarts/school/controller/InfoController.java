package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.PortService;

@RestController
public class InfoController {
    PortService portService;

    public InfoController(PortService portService) {
        this.portService = portService;
    }

    @GetMapping("port")
    public Integer getPort(){
        return portService.getPort();
    }
}
