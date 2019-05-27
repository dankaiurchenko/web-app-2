package com.danarossa.webapp2.repository;

import com.danarossa.webapp2.data.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Query(value = "select a.* from courses a join realized_courses b using (course_id) where b.realized_course_id = ?1",
                nativeQuery = true)
    Optional<Course> findByRealizedCourseId(Integer realizedCourseId);

    @Query(value = "select distinct sc.* \n" +
            "  from STUDENTS_COURSES sc \n" +
            "  join REALIZED_COURSES rc using (realized_course_id) \n" +
            "  join COURSES c using (course_id) where STUDENT_ID = ?1", nativeQuery = true)
    List<Course> findByStudentId(Integer studentId);

    @Query(value = "select a.* from courses a where lecturer_id = ?1", nativeQuery = true)
    List<Course> findByLecturerId(Integer lecturerId);
}

