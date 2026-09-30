package com.douaa.course.service;

import com.douaa.course.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT")
public interface APIClient {
    @GetMapping("api/students/{student-code}")
    StudentDto getStudentByCode(@PathVariable("student-code") String studentCode);
}