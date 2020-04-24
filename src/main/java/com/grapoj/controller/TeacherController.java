package com.grapoj.controller;


import com.grapoj.domain.Project;
import com.grapoj.domain.user.Teacher;
import com.grapoj.domain.user.User;
import com.grapoj.service.ProjectService;
import com.grapoj.service.TeacherService;
import com.grapoj.tool.tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.grapoj.tool.tools.getCurrentTime;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/main.html")
    public String main(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") != null && session.getAttribute("teacher") != null) {
            return "/teacher/teacher_main";
        } else {
            session.invalidate();
            return "/login/login_main";
        }
    }

    @RequestMapping("/project/publish")
    public String projectPub() {
        System.out.println("教师发布课题...");
        return "/teacher/teacher_project_publish";
    }

    @RequestMapping("/project/publish/commit")
    public String pubProject(String title, String detail, HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("teacher") == null) {
            session.invalidate();
            return "/login/login_main";
        }
        String currentDate = tools.getCurrentDate();
        System.out.println("添加毕设...");
        //        2表示为教师发布的课题，需审核
        Project project = new Project(title, detail, currentDate,
                ((Teacher) session.getAttribute("teacher")).getTeaID(),
                ((User)session.getAttribute("user")).getPermission()+1);
        projectService.pubProject(project);
        request.setAttribute("pub_success", "发布成功");
        return "redirect:/teacher/main.html";
    }

    @RequestMapping("/project/list")
    public String projectListOfTeacher(HttpSession session) {
        if (session.getAttribute("teacher") == null) {
            return "login/login_main";
        }
        if (session.getAttribute("projects") != null) {
            session.removeAttribute("projects");
        }
        List<Project> projects = projectService.findAllProjectByTeaID(
                ((Teacher) session.getAttribute("teacher")).getTeaID());
        session.setAttribute("projects", projects);
        return "/teacher/teacher_project_list";
    }


    @RequestMapping("/project/update/{projectID}")
    public String update(@PathVariable(name = "projectID") String projectID, HttpSession session) {
        System.out.println("更新课题...");
        Project project = projectService.findProjectByID(projectID);
        System.out.println(project);
        session.setAttribute("project", project);
        return "/teacher/teacher_project_update";
    }

    @RequestMapping("/project/recommit/{projectID}")
    public String projectRecommit(@PathVariable(name = "projectID") String projectID, HttpSession session) {
        System.out.println("重新发布课题...");
        projectService.updateStatusByID(
                ((User)session.getAttribute("user")).getPermission()+1, projectID);
        return "redirect:/teacher/main.html";
    }

    @RequestMapping("/project/update/commit")
    public String updateCommit(String title, String detail, HttpSession session) {
        Project project = (Project) session.getAttribute("project");
        project.setTitle(title);
        project.setDetail(detail);
        project.setDate(getCurrentTime());
        System.out.println(project);
        projectService.updateProject(project);
        return "redirect:/teacher/main.html";
    }

    @RequestMapping("/project/delete/{projectID}")
    public String delete(@PathVariable(name = "projectID") String projectID) {
        System.out.println("撤销课题...");
        System.out.println(projectID);
        projectService.deleteProject(projectID);
        return "redirect:/teacher/main.html";
    }

    @RequestMapping("/project/nopass")
    public String projectNoPass(HttpSession session) {
        System.out.println("查看未审核课题...");
        List<Project> projects = projectService.findAllProjectByNotStatusAndTeacherID(5,
                ((Teacher) session.getAttribute("teacher")).getTeaID());
        session.setAttribute("projects", projects);
        return "/teacher/teacher_project_list";
    }

    @RequestMapping("/project/passfail")
    public String projectPassFail(HttpSession session) {
        System.out.println("查看审核失败的课题...");
        List<Project> projects = projectService.findAllProjectByStatusAndTeacherID(0,
                ((Teacher) session.getAttribute("teacher")).getTeaID());
        session.setAttribute("projects", projects);
        return "/teacher/teacher_project_list";
    }

    @RequestMapping("/project/check")
    public String projectCheck(HttpSession session) {
        System.out.println("查看系统待审核的课题...");
        List<Project> projects = projectService.findAllProjectByStatus(
                ((User) session.getAttribute("user")).getPermission()
        );
        System.out.println(projects);
        session.setAttribute("projects", projects);
        return "/teacher/teacher_project_check";
    }

    @RequestMapping("/project/check/pass/{projectID}")
    public String projectCheckPass(@PathVariable("projectID") String projectID, HttpSession session) {
        System.out.println("课题通过审核...");
        projectService.updateStatusByID(
                ((User) session.getAttribute("user")).getPermission() + 1, projectID
        );
        return "redirect:/teacher/project/check";
    }
    @RequestMapping("/project/check/nopass/{projectID}")
    public String projectCheckNoPass(@PathVariable("projectID") String projectID, HttpSession session) {
        System.out.println("课题未通过审核...");
        projectService.updateStatusByID(
                0, projectID
        );
        return "redirect:/teacher/project/check";
    }

}
