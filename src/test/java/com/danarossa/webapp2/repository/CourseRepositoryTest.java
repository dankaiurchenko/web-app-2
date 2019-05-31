package com.danarossa.webapp2.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    @Test
    public void findByRealizedCourseId() {
        assertEquals(courseRepository.findById(1),  courseRepository.findByRealizedCourseId(1));
    }

    @Transactional
    @Test
    public void findByStudentId() {
    }

    @Transactional
    @Test
    public void findByLecturerId() {
        System.out.println(courseRepository.findByLecturerId(1));
    }
}