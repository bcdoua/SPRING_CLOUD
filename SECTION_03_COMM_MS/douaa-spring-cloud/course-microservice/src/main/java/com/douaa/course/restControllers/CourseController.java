package com.douaa.course.restControllers;

import com.douaa.course.dto.APIResponseDto;
import com.douaa.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getCourseById(@PathVariable("id") Long id) {
        return new ResponseEntity<APIResponseDto>(
                courseService.getCourseById(id), HttpStatus.OK);
    }
}