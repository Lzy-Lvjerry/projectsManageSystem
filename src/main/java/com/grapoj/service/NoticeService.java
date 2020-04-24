package com.grapoj.service;

import com.grapoj.domain.Notice;

import java.util.List;

public interface NoticeService {
    public void saveNotice(Notice notice);
    public List<Notice> findAllNotice();
    public Notice findNoticeByID(String noticeID);
    public void deleteNotice(String noticeID);
    public void updateNotice(Notice notice);

}
