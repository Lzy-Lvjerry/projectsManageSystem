package com.grapoj.dao;

import com.grapoj.domain.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    @Insert("insert into notices (detail,date,headline) values (#{detail},#{date},#{headline})  ")
    public void saveNotice(Notice notice);

    @Select("select * from notices")
    public List<Notice> findAllNotice();

    @Select("select * from notices where noticeID=#{noticeID}")
    public Notice findNoticeByID(String noticeID);

    @Delete("delete from notices where noticeID=#{noticeID}")
    public void deleteNotice(String noticeID);

    @Update("update notices set detail=#{detail},date=#{date},headline=#{headline} where noticeID=#{noticeID}")
    public void updateNotice(Notice notice);
}
