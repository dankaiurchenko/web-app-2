package com.danarossa.webapp2.dto;

import com.danarossa.webapp2.data.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithMark {
    private User student;
    private DtoMark dtoMark;
}
