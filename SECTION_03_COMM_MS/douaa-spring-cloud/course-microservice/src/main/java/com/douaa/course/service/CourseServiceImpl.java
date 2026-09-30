package com.douaa.course.service;

import com.douaa.course.dto.APIResponseDto;
import com.douaa.course.dto.CourseDto;
import com.douaa.course.dto.StudentDto;
import com.douaa.course.entities.Course;
import com.douaa.course.repos.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();

        StudentDto studentDto = apiClient.getStudentByCode(course.getStudentCode());

        CourseDto courseDto = new CourseDto(
                course.getId(),
                course.getCourseName(),
                course.getCourseCode(),
                course.getStudentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setCourseDto(courseDto);
        apiResponseDto.setStudentDto(studentDto);

        return apiResponseDto;
    }
}