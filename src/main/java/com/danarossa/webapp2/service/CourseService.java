package com.danarossa.webapp2.service;

import com.danarossa.webapp2.data.Course;
import com.danarossa.webapp2.data.RealizedCourse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface CourseService {
    Iterable<Course> all();

    Integer add(Course courseCourse);

    String edit(Course[] courses);

    String editOne( Course course);

    String delete(Course[] courses);

    String deleteOne(Course course);

    Optional<Course> byId(Integer courseId);

    Iterable<RealizedCourse> allOfCourse(Integer courseId);
}
