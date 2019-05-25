package com.danarossa.webapp2.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courses", schema = "public", catalog = "my_servlet_project")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String title;
    private Integer numberOfHours;
    private Integer hoursForLectures;
    private Integer hoursForPractice;
    private Integer lecturerId;

}
