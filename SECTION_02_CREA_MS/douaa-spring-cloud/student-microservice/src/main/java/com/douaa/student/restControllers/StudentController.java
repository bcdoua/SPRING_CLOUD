package com.douaa.student.restControllers;

import com.douaa.student.config.Configuration;
import com.douaa.student.dto.StudentDto;
import com.douaa.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@RefreshScope
public class StudentController {
    private final StudentService studentService;
    private final Configuration configuration;

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("{code}")
    public ResponseEntity<StudentDto> getStudentByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(studentService.getStudentByCode(code), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName() + " " + configuration.getEmail());
    }
}