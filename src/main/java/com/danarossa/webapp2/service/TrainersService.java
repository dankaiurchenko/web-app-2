package com.danarossa.webapp2.service;

import com.danarossa.webapp2.data.Course;
import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.data.User;

public interface TrainersService {
    Iterable<RealizedCourse> realizedCoursesOfLecturer(Integer trainerId);

    Iterable<Course> coursesOfLecturer(Integer trainerId);

    Iterable<User> allTrainers();
}
