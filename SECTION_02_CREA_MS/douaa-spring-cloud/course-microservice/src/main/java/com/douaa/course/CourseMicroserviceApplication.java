package com.douaa.course;

import com.douaa.course.entities.Course;
import com.douaa.course.repos.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class CourseMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository) {
        return args -> {
            courseRepository.save(Course.builder()
                    .courseName("Spring Cloud")
                    .courseCode("C001")
                    .studentCode("S001")
                    .build());
        };
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}