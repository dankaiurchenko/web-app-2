package com.danarossa.webapp2.service;

import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.dto.StudentWithMark;

import java.util.List;
import java.util.Optional;

public interface RealizedCourseService {
    Iterable<RealizedCourse> all();

    Optional<RealizedCourse> byId(Integer realizedCourseId);

    Integer createNew(RealizedCourse realizedCourse);

    Integer edit(RealizedCourse realizedCourse);

    String delete(Integer realizedCourseId);

    List<StudentWithMark> allOfCourse(Integer realizedCourseId);
}
