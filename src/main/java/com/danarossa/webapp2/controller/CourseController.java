package com.danarossa.webapp2.controller;


import com.danarossa.webapp2.data.Course;
import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Iterable<Course> all() {
        return courseService.all();
    }

    @PostMapping
    public Integer add(@RequestBody @Valid  Course courseCourse) {
        courseService.add(courseCourse);
        return courseCourse.getCourseId();
    }

    @PutMapping
    public String edit(@RequestBody @Valid Course[] courses) {
        return courseService.edit(courses);
    }

    @PutMapping("/{courseId}")
    public String editOne(@RequestBody @Valid Course course) {
        return courseService.editOne(course);
    }

    @DeleteMapping
    public String delete(@RequestBody @Valid Course[] courses) {
        return courseService.delete(courses);
    }

    @DeleteMapping("/{courseId}")
    public String deleteOne(@RequestBody @Valid Course course) {
        return courseService.deleteOne(course);
    }

    @GetMapping("/{courseId}")
    public Optional<Course> byId(@PathVariable Integer courseId) {
        return courseService.byId(courseId);
    }

    @GetMapping("/{courseId}/realized")
    public Iterable<RealizedCourse> allOfCourse(@PathVariable Integer courseId) {
        return courseService.allOfCourse(courseId);

    }

}
