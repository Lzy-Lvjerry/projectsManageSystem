package com.grapoj.domain.user;

public class Teacher extends People {
    private String teaID;
    private String department;
    private String position;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teaID='" + teaID + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                "} " + super.toString();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeaID() {
        return teaID;
    }

    public void setTeaID(String teaID) {
        this.teaID = teaID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
