package com.grapoj.service.impl;

import com.grapoj.dao.StudentDao;
import com.grapoj.domain.user.Student;
import com.grapoj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findStudentByID(String stuID) {
        return studentDao.findStudentByID(stuID);
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public void deleteStudentByStuID(String stuID) {
        studentDao.deleteStudentByStuID(stuID);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> findAllStudentByYearClass(Integer yearClass) {
        return studentDao.findAllStudentByYearClass(yearClass);
    }

    @Override
    public void updateStudentProjectID(String stuID, String projectID) {
        studentDao.updateStudentProjectID(stuID,projectID);
    }
}
