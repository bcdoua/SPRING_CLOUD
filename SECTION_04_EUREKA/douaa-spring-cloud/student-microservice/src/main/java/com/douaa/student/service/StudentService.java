package com.douaa.student.service;

import com.douaa.student.dto.StudentDto;

public interface StudentService {
    StudentDto getStudentByCode(String code);
}