package com.danarossa.webapp2.service.implementation;

import com.danarossa.webapp2.data.Course;
import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.data.Role;
import com.danarossa.webapp2.data.User;
import com.danarossa.webapp2.repository.CourseRepository;
import com.danarossa.webapp2.repository.RealizedCourseRepository;
import com.danarossa.webapp2.repository.UserRepository;
import com.danarossa.webapp2.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainersServiceImpl implements TrainersService {

    @Autowired
    private RealizedCourseRepository realizedCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<RealizedCourse> realizedCoursesOfLecturer(Integer trainerId) {
        return realizedCourseRepository.findByLecturerId(trainerId);
    }

    @Override
    public Iterable<Course> coursesOfLecturer(Integer trainerId) {
        return courseRepository.findByLecturerId(trainerId);
    }

    @Override
    public Iterable<User> allTrainers() {
        return userRepository.findByRole(Role.TRAINER);
    }
}
