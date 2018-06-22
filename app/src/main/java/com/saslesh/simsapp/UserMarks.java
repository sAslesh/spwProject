package com.saslesh.simsapp;

public class UserMarks {
    private String Marks;
    private String Sub;
    private String Date;

    public UserMarks(String marks, String sub, String date) {
        Marks = marks;
        Sub = sub;
        Date = date;
    }

    public String getMarks() {
        return Marks;
    }

    public void setMarks(String marks) {
        Marks = marks;
    }

    public String getSub() {
        return Sub;
    }

    public void setSub(String sub) {
        Sub = sub;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
    public UserMarks(){

    }


}
