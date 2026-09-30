package com.douaa.student.repos;

import com.douaa.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentCode(String code);
}