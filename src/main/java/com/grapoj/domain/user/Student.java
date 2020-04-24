package com.grapoj.domain.user;

public class Student extends People {
    private String stuID;
    private String department;
    private String subject;
    private String projectID;
    private Integer yearClass;

    @Override
    public String toString() {
        return "Student{" +
                "stuID='" + stuID + '\'' +
                ", department='" + department + '\'' +
                ", subject='" + subject + '\'' +
                ", projectID='" + projectID + '\'' +
                ", yearClass=" + yearClass +
                "} " + super.toString();
    }

    public Student() {
    }

    public Integer getYearClass() {
        return yearClass;
    }

    public void setYearClass(Integer yearClass) {
        this.yearClass = yearClass;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
