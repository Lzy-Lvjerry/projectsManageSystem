package com.grapoj.domain;

public class Notice {
    private Integer noticeID;
    private String headline;
    private String detail;
    private String date;

    public Notice() {
    }

    public Notice(String headline, String detail, String date) {
        this.headline = headline;
        this.detail = detail;
        this.date = date;
    }

    public Notice(Integer noticeID, String headline, String detail, String date) {
        this.noticeID = noticeID;
        this.headline = headline;
        this.detail = detail;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeID='" + noticeID + '\'' +
                ", headline='" + headline + '\'' +
                ", detail='" + detail + '\'' +
                ", date=" + date +
                '}';
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public Integer getNoticeID() {
        return noticeID;
    }

    public void setNoticeID(Integer noticeID) {
        this.noticeID = noticeID;
    }

    public String getdetail() {
        return detail;
    }

    public void setdetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
