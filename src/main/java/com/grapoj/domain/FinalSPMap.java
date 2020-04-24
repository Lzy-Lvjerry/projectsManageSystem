package com.grapoj.domain;

public class FinalSPMap {
    private String studentID;
    private String studentName;
    private Integer projectID;
    private String projectName;

    public FinalSPMap() {
    }

    public FinalSPMap(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public FinalSPMap(String studentID, String studentName, Integer projectID, String projectName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.projectID = projectID;
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "FinalMap{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", projectID='" + projectID + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
