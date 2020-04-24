package com.grapoj.controller;


import com.grapoj.domain.FinalSPMap;
import com.grapoj.domain.Project;
import com.grapoj.domain.user.Student;
import com.grapoj.service.AdministratorService;
import com.grapoj.service.ProjectService;
import com.grapoj.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/administrator")
public class AdminController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/main.html")
    public String main(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") != null && session.getAttribute("administrator") != null) {
            return "/administrator/administrator_main";
        } else {
            session.invalidate();
            return "/login/login_main";
        }
    }

    @RequestMapping("/project/check")
    public String projectCheck(HttpSession session) {
        List<Project> projects = projectService.findAllProjectByStatus(2);
        session.setAttribute("projects", projects);
        return "/administrator/administrator_project_check";
    }

    @RequestMapping("/project/check/pass/{projectID}")
    public String projectCheckPass(@PathVariable String projectID) {
        projectService.updateStatusByID(3, projectID);
        System.out.println("更新状态成功");
        return "redirect:/administrator/project/check";
    }

    @RequestMapping("/project/check/nopass/{projectID}")
    public String projectCheckNoPass(@PathVariable String projectID) {
        projectService.updateStatusByID(0, projectID);
        System.out.println("更新状态成功");
        return "redirect:/administrator/project/check";
    }

    @RequestMapping("/project/adjustment")
    public String projectAdjustment(HttpSession session, Integer yearClass) {
        System.out.println(yearClass);
        if (session.getAttribute("yearClass") != null && yearClass == null) {
            yearClass = (Integer) session.getAttribute("yearClass");
        }
        List<FinalSPMap> spMapList = new LinkedList<>();
        List<Student> students = studentService.findAllStudentByYearClass(yearClass);
        for (Student student :
                students) {
            FinalSPMap spMap = new FinalSPMap(student.getStuID(), student.getName());
            Project project = projectService.findProjectByID(student.getProjectID());
            if (project == null) {
                spMap.setProjectID(null);
                spMap.setProjectName("none");
            } else {
                spMap.setProjectID(project.getProjectID());
                spMap.setProjectName(project.getTitle());
            }
            spMapList.add(spMap);
        }
        session.setAttribute("yearClass", yearClass);
        session.setAttribute("spMapList", spMapList);
        return "/administrator/administrator_adjustSP";
    }

    @RequestMapping("/project/adjust/{studentID}")
    public String projectAdjustStudent(@PathVariable("studentID") String studentID, HttpSession session) {
        Student student = studentService.findStudentByID(studentID);
        Project project = projectService.findProjectByID(student.getProjectID());
        System.out.println(student);
        System.out.println(project);
        FinalSPMap spMap = new FinalSPMap(student.getStuID(), student.getName());
        if (project==null){
            spMap.setProjectID(null);
            spMap.setProjectName("none");
        }else {
            spMap.setProjectID(project.getProjectID());
            spMap.setProjectName(project.getTitle());
        }
        session.setAttribute("spMap", spMap);
        session.setAttribute("student", student);
        return "/administrator/administrator_adjust_commit";
    }

    @RequestMapping("/project/adjust/{studentID}/commit")
    public String projectAdjustStudentCommit(
            @PathVariable("studentID") String studentID, String newProjectID, HttpSession session) {

        if (projectService.findProjectByID(newProjectID) == null) {
            System.out.println("未找到课题: " + newProjectID);
            return "forward:/administrator/project/adjustment/";
        }
        System.out.println("更新课题ID");
        studentService.updateStudentProjectID(
                projectService.findProjectByID(newProjectID).getStudentID(), null
        );
        studentService.updateStudentProjectID(studentID, newProjectID);
        System.out.println("更新学生ID");
        projectService.updateStudentID(
                ((Student) session.getAttribute("student")).getProjectID(), null
        );
        projectService.updateStudentID(newProjectID, studentID);
        return "forward:/administrator/project/adjustment/";
    }

    @RequestMapping("/insert/student")
    public String insertStudent() {
        return "/student/student_insert";
    }

    @RequestMapping("/notice/publish")
    public String noticePub() {
        return "/notice/notice_pub";
    }

    @RequestMapping("/project/add")
    public String addProject() {
        return "/project/project_add";
    }
}
