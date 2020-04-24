package com.grapoj.tool;

public class tools {
    public static String getCurrentTime(){
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date currentTime = new java.util.Date();
        return formatter.format(currentTime);
    }

    public static String getCurrentDate(){
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date currentDate = new java.util.Date();
        return formatter.format(currentDate);
    }
}
