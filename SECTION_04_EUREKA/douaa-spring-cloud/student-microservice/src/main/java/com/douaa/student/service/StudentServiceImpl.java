package com.douaa.student.service;

import com.douaa.student.dto.StudentDto;
import com.douaa.student.entities.Student;
import com.douaa.student.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDto getStudentByCode(String code) {
        Student student = studentRepository.findByStudentCode(code);
        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getStudentName(),
                student.getStudentCode()
        );
        return studentDto;
    }
}