package com.grapoj.service;

import com.grapoj.domain.user.Student;

import java.util.List;


public interface StudentService {
    public Student findStudentByID(String stuID);

    public void saveStudent(Student student);

    public void deleteStudentByStuID(String stuID);

    public void updateStudent(Student student);
    public List<Student> findAllStudentByYearClass(Integer yearClass);
    public void updateStudentProjectID(String stuID, String projectID);

}
