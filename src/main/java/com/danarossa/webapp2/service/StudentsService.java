package com.danarossa.webapp2.service;

import com.danarossa.webapp2.data.Course;
import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.data.User;
import com.danarossa.webapp2.dto.ArchiveItem;
import com.danarossa.webapp2.dto.StudentWithMark;

import java.util.List;

public interface StudentsService {
    Iterable<User> allStudents();

    Iterable<Course> allOfStudent(Integer studentId);

    List<StudentWithMark> allTrainersOfStudent(Integer studentId);

    Iterable<RealizedCourse> coursesOfStudent(Integer studentId);

    List<ArchiveItem> marksOfStudent(Integer studentId);
}
