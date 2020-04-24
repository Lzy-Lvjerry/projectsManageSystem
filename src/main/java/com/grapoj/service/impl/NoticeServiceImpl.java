package com.grapoj.service.impl;

import com.grapoj.dao.NoticeDao;
import com.grapoj.domain.Notice;
import com.grapoj.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;


    @Override
    public void saveNotice(Notice notice) {
        noticeDao.saveNotice(notice);
    }

    @Override
    public List<Notice> findAllNotice() {
        return noticeDao.findAllNotice();
    }

    @Override
    public Notice findNoticeByID(String noticeID) {
        return noticeDao.findNoticeByID(noticeID);
    }

    @Override
    public void deleteNotice(String noticeID) {
        noticeDao.deleteNotice(noticeID);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeDao.updateNotice(notice);
    }

}
