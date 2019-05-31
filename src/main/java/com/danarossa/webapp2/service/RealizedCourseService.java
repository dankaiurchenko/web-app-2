package com.danarossa.webapp2.service;

import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.dto.StudentWithMark;

import java.util.List;

public interface RealizedCourseService {
    Iterable<RealizedCourse> all();

    RealizedCourse byId(Integer realizedCourseId);

    RealizedCourse createNew(RealizedCourse realizedCourse);

    RealizedCourse edit(RealizedCourse realizedCourse);

    void delete(Integer realizedCourseId);

    List<StudentWithMark> allOfCourse(Integer realizedCourseId);
}
