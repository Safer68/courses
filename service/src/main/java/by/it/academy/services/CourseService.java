package by.it.academy.services;

import by.it.academy.repository.entity.Course;
import by.it.academy.services.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<Course> findCourseById(Integer id);
    List<Course> findAllCourse();
    List<Course> findAllCourseWithoutMentor();
    Optional<Course> findCourseById(Integer id);
}
