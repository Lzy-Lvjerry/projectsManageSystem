package com.grapoj.controller;

import com.grapoj.domain.Notice;
import com.grapoj.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.grapoj.tool.tools.getCurrentTime;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;



    @RequestMapping("/publish")
    public String pub_notice(String headline,String detail, HttpServletRequest request){
        System.out.println("发布信息中...");
        String cur_date = getCurrentTime();
        Notice notice = new Notice(headline,detail,cur_date);
        System.out.println(notice);
        noticeService.saveNotice(notice);
        System.out.println("获取全部通知...");
        request.setAttribute("pub_success","发布成功");

        return "redirect:/notice/notice_main.html";
    }

    @RequestMapping(value="notice_main.html",method = RequestMethod.GET)
    public String main(HttpSession session, HttpServletRequest request){
        if(session.getAttribute("notices")!=null){
            session.removeAttribute("notices");
        }
        List<Notice> notices = noticeService.findAllNotice();
        session.setAttribute("notices",notices);
        return "/notice/notice_main";
    }

    @RequestMapping(value = "/detail/{noticeID}")
    public String detail(@PathVariable (name = "noticeID")String noticeID,HttpSession session){
        Notice notice = noticeService.findNoticeByID(noticeID);
        System.out.println(notice);
        session.setAttribute("notice",notice);
        return "/notice/notice_detail";
    }

    @RequestMapping("/delete/{noticeID}")
    public String delete(@PathVariable (name = "noticeID")String noticeID){
        System.out.println("删除通知...");
        System.out.println(noticeID);
        noticeService.deleteNotice(noticeID);
        return "redirect:/notice/notice_main.html";
    }

    @RequestMapping("/update/{noticeID}")
    public String update(@PathVariable (name = "noticeID")String noticeID,HttpSession session){
        System.out.println("更新通知...");
        Notice notice = noticeService.findNoticeByID(noticeID);
        System.out.println(notice);
        session.setAttribute("notice",notice);
        return "/notice/notice_update";
    }
    @RequestMapping("/update/commit")
    public String updateCommit(Notice notice){
        notice.setDate(getCurrentTime());
        System.out.println(notice);
        noticeService.updateNotice(notice);
        return "redirect:/notice/notice_main.html";
    }
}
