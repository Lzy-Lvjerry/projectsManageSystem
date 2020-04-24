package com.grapoj.service;


import com.grapoj.domain.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectService {
    public List<Project> findAllProject();
    public void addProject(Project project);
    public void pubProject(Project project);
    public Project findProjectByID(String projectID);
    public void deleteProject(String projectID);
    public void updateProject(Project project);
    public List<Project> findAllProjectOfUnselected();
    public List<Project> findAllProjectByTeaID(String teaID);
    public List<Project> findAllProjectByStatus(Integer status);
    public List<Project> findAllProjectByStatusAndTeacherID(Integer status, String teacherID);
    public List<Project> findAllProjectByNotStatusAndTeacherID(Integer status,String teacherID);

    public void updateStatusByID(Integer status,String projectID);
    public void updateStudentID(String projectID, String studentID);

}
