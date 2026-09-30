package com.douaa.course.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.douaa.course.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}