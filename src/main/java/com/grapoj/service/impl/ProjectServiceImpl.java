package com.grapoj.service.impl;


import com.grapoj.dao.ProjectDao;
import com.grapoj.domain.Project;
import com.grapoj.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> findAllProject() {
        return projectDao.findAllProject();
    }

    @Override
    public void addProject(Project project) {
        projectDao.addProject(project);
    }

    @Override
    public void pubProject(Project project) {
        projectDao.pubProject(project);
    }

    @Override
    public Project findProjectByID(String projectID) {
        return projectDao.findProjectByID(projectID);
    }

    @Override
    public void deleteProject(String projectID) {
        projectDao.deleteProject(projectID);
    }

    @Override
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }

    @Override
    public List<Project> findAllProjectOfUnselected() {
        return projectDao.findAllProjectOfUnselected();
    }

    @Override
    public List<Project> findAllProjectByTeaID(String teaID) {
        return projectDao.findAllProjectByTeaID(teaID);
    }

    @Override
    public List<Project> findAllProjectByStatus(Integer status) {
        return projectDao.findAllProjectByStatus(status);
    }

    @Override
    public List<Project> findAllProjectByStatusAndTeacherID(Integer status, String teacherID) {
        return projectDao.findAllProjectByStatusAndTeacherID(status,teacherID);
    }

    @Override
    public List<Project> findAllProjectByNotStatusAndTeacherID(Integer status, String teacherID) {
        return projectDao.findAllProjectByNotStatusAndTeacherID(status,teacherID);
    }

    @Override
    public void updateStatusByID(Integer status, String projectID) {
        projectDao.updateStatusByID(status, projectID);
    }

    @Override
    public void updateStudentID(String projectID, String studentID) {
        projectDao.updateStudentID(projectID,studentID);
    }

}
