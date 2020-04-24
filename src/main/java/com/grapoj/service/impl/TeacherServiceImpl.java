package com.grapoj.service.impl;

import com.grapoj.dao.TeacherDao;
import com.grapoj.domain.user.Teacher;
import com.grapoj.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Teacher findTeacherByID(String teaID) {
        return teacherDao.findTeacherByID(teaID);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherDao.saveTeacher(teacher);
    }

    @Override
    public void deleteTeacherByStuID(String teaID) {
        teacherDao.deleteTeacherByStuID(teaID);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }
}
