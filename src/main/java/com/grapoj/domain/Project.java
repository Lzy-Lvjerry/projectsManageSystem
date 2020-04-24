package com.grapoj.domain;

import java.sql.Date;

public class Project {
//    自增长
    private Integer projectID;
    private String title;
    private String detail;
    private String date;
    private String teacherID;
    private String studentID;
    private Integer status;

//    1表示已被选，0表示未被选
    private Integer hasSelected;

    public Project() {
    }

    public Project(String title, String detail, String date) {
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.hasSelected = 0;
    }

    public Project(String title, String detail, String date, String teacherID, Integer status) {
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.teacherID = teacherID;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID='" + projectID + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", date='" + date + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", studentID='" + studentID + '\'' +
                ", status=" + status +
                ", hasSelected=" + hasSelected +
                '}';
    }

    public Integer getHasSelected() {
        return hasSelected;
    }

    public void setHasSelected(Integer hasSelected) {
        this.hasSelected = hasSelected;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUnselected(){
        this.setHasSelected(0);
        this.setStudentID(null);
    }
    public void setSelected(String studentID){
        this.setHasSelected(1);
        this.setStudentID(studentID);
    }
}
