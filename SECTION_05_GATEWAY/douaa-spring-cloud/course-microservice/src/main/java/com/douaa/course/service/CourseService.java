package com.douaa.course.service;

import com.douaa.course.dto.APIResponseDto;

public interface CourseService {
    APIResponseDto getCourseById(Long id);
}