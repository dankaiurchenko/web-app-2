package com.danarossa.webapp2.service.implementation;

import com.danarossa.webapp2.data.Course;
import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.repository.CourseRepository;
import com.danarossa.webapp2.repository.RealizedCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CourseServiceImpl implements com.danarossa.webapp2.service.CourseService {
    @Autowired
    public RealizedCourseRepository realizedCourseRepository;
    @Autowired
    public CourseRepository courseRepository;

    public CourseServiceImpl() {
    }

    @Override
    public Iterable<Course> all() {
        return courseRepository.findAll();
    }

    @Override
    public Integer add(Course courseCourse) {
        courseRepository.save(courseCourse);
        return courseCourse.getCourseId();
    }

    @Override
    public String edit(Course[] courses) {
        Arrays.stream(courses).forEach(courseRepository::save);
        return "All edited";
    }

    @Override
    public String editOne(Course course) {
        courseRepository.save(course);
        return "Edited";
    }

    @Override
    public String delete(Course[] courses) {
        Arrays.stream(courses).forEach(courseRepository::delete);
        return "All deleted";
    }

    @Override
    public String deleteOne(Course course) {
        courseRepository.save(course);
        return "Deleted";
    }

    @Override
    public Optional<Course> byId(Integer courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Iterable<RealizedCourse> allOfCourse(Integer courseId) {
        return realizedCourseRepository.findByCourseId(courseId);

    }
}