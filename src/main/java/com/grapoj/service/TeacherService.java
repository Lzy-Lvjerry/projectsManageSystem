package com.grapoj.service;

import com.grapoj.domain.user.Teacher;


public interface TeacherService {

    public Teacher findTeacherByID(String teaID);

    public void saveTeacher(Teacher teacher);

    public void deleteTeacherByStuID(String teaID);

    public void updateTeacher(Teacher teacher);

}
