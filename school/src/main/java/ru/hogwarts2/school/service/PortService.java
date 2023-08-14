package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PortService {
    Logger log = LoggerFactory.getLogger(PortService.class);

    @Value("${server.port}")
    private Integer port;

    public Integer getPort() {
        log.info("port={}", port);
        return port;
    }
}
