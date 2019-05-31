package com.danarossa.webapp2.service.implementation;

import com.danarossa.webapp2.data.RealizedCourse;
import com.danarossa.webapp2.data.StudentsCourse;
import com.danarossa.webapp2.data.User;
import com.danarossa.webapp2.dto.DtoMark;
import com.danarossa.webapp2.dto.StudentWithMark;
import com.danarossa.webapp2.repository.RealizedCourseRepository;
import com.danarossa.webapp2.repository.StudentsCourseRepository;
import com.danarossa.webapp2.repository.UserRepository;
import com.danarossa.webapp2.service.ServiceException;
import com.danarossa.webapp2.service.RealizedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RealizedCourseServiceImpl implements RealizedCourseService {

    @Autowired
    private RealizedCourseRepository realizedCourseRepository;

    @Autowired
    private StudentsCourseRepository studentsCourseRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<RealizedCourse> all() {
        return realizedCourseRepository.findAll();
    }


    @Override
    public RealizedCourse byId(Integer realizedCourseId) {
        return realizedCourseRepository.findById(realizedCourseId)
                .orElseThrow(() -> new ServiceException("Realized Course not found!"));

    }

    @Override
    public RealizedCourse createNew(RealizedCourse realizedCourse) {
        realizedCourseRepository.save(realizedCourse);
        return realizedCourse;

    }


    @Override
    public RealizedCourse edit(RealizedCourse realizedCourse) {
        realizedCourseRepository.save(realizedCourse);
        return realizedCourse;
    }


    @Override
    public void delete(Integer realizedCourseId) {
        Optional<RealizedCourse> byId = realizedCourseRepository.findById(realizedCourseId);
        if (byId.isPresent())
            realizedCourseRepository.delete(byId.get());
        else {
            throw new ServiceException("Cannot delete realized course");
        }
    }


    @Override
    public List<StudentWithMark> allOfCourse(Integer realizedCourseId) {
        List<User> allStudentsOfRealizedCourse = userRepository.findStudentsByRealizedCourseId(realizedCourseId);
        List<StudentWithMark> studentWithMarks = new ArrayList<>();
        for (User user : allStudentsOfRealizedCourse) {
            Optional<StudentsCourse> studentsCourseForStudentAndRealizedCourse =
                    studentsCourseRepository.findByStudentIdAndRealizedCourseId(
                            user.getUserId(), realizedCourseId);
            studentsCourseForStudentAndRealizedCourse.
                    ifPresent(studentsCourse -> studentWithMarks.add(
                            new StudentWithMark(user, new DtoMark(studentsCourse))));
        }
        return studentWithMarks;
    }

}
