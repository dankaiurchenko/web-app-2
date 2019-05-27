package com.danarossa.webapp2.controller;

import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.dto.StudentWithMark;
import com.danarossa.webapp2.service.RealizedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/realized-courses")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RealizedCourseController {
    @Autowired
    private RealizedCourseService realizedCourseService;

    @GetMapping
    public Iterable<RealizedCourse> all() {
        return realizedCourseService.all();
    }


    @GetMapping("/{realizedCourseId}")
    public Optional<RealizedCourse> byId(@PathVariable Integer realizedCourseId) {
        return realizedCourseService.byId(realizedCourseId);

    }

    @PostMapping
    public Integer createNew(@RequestBody @Valid RealizedCourse realizedCourse) {
        return realizedCourseService.createNew(realizedCourse);

    }

    @PutMapping
    public Integer edit(@RequestBody @Valid RealizedCourse realizedCourse) {
        return realizedCourseService.edit(realizedCourse);
    }

    @DeleteMapping("/{realizedCourseId}")
    public String delete(@PathVariable Integer realizedCourseId) {
        return realizedCourseService.delete(realizedCourseId);
    }

    @GetMapping("/{realizedCourseId}/students")
    public List<StudentWithMark> allOfCourse(@PathVariable Integer realizedCourseId) {
        return realizedCourseService.allOfCourse(realizedCourseId);
    }


}
