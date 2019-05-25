package com.danarossa.webapp2.dto;

import com.danarossa.webapp2.data.StudentsCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoMark {
    private Integer id;
    private Integer studentId;
    private Integer realizedCourseId;
    private Integer mark;

    public DtoMark(StudentsCourse studentMark) {
        this.id = studentMark.getStudentCourseId();
        this.studentId = studentMark.getStudentId();
        this.realizedCourseId = studentMark.getRealizedCourseId();
        this.mark = studentMark.getMark();
    }
}
