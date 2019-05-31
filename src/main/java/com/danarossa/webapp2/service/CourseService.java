package com.danarossa.webapp2.service;

import com.danarossa.webapp2.data.Course;
import com.danarossa.webapp2.data.RealizedCourse;

import java.util.Optional;

public interface CourseService {
    Iterable<Course> all();

    Integer add(Course courseCourse);

    void edit(Course[] courses);

    void editOne(Course course);

    void delete(Course[] courses);

    void deleteOne(Course course);

    Course byId(Integer courseId);

    Iterable<RealizedCourse> allOfCourse(Integer courseId);
}
