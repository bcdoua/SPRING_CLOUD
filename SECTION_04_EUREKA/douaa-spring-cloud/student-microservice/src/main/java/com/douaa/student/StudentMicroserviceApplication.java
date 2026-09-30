package com.douaa.student;

import com.douaa.student.entities.Student;
import com.douaa.student.repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(Student.builder()
                    .studentName("Douaa Ben Charef")
                    .studentCode("S001")
                    .build());
            studentRepository.save(Student.builder()
                    .studentName("Samar Jallouli")
                    .studentCode("S002")
                    .build());
        };
    }
}