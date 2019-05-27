package com.danarossa.webapp2.repository;

import com.danarossa.webapp2.data.StudentsCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsCourseRepository extends CrudRepository<StudentsCourse, Integer> {

    Optional<StudentsCourse> findByStudentIdAndRealizedCourseId(Integer studentId, Integer realizedCourseId);

    List<StudentsCourse> findByStudentId(Integer studentId);
}
