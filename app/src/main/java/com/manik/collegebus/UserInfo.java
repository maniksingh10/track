package com.manik.collegebus;

public class UserInfo {

    private String name;
    private String course;
    private String mobile;
    private String uID;

    public UserInfo(){

    }
    public UserInfo(String name, String course, String mobile,String uID) {
        this.name = name;
        this.course = course;
        this.mobile = mobile;
        this.uID = uID;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getMobile() {
        return mobile;
    }

    public String getuID() {
        return uID;
    }
}
