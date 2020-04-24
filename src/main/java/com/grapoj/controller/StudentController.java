package com.grapoj.controller;

import com.grapoj.domain.Project;
import com.grapoj.domain.user.Student;
import com.grapoj.domain.user.User;
import com.grapoj.service.ProjectService;
import com.grapoj.service.StudentService;
import com.grapoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;


    @RequestMapping(value = "/main.html")
    public String main(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") != null && session.getAttribute("student") != null) {
            return "student/student_main";
        } else {
            session.invalidate();
            return "/login/login_main";
        }
    }

    @RequestMapping(value = "/update")
    public String update(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("student") == null) {
            return "redirect:/user/login";
        } else {
            return "/student/student_update";
        }
    }

    @RequestMapping("/update_success")
    public String update(Student student, String password, HttpSession session, HttpServletRequest request) {
        System.out.println("修改学生信息");
        studentService.updateStudent(student);
        User user = new User(student.getStuID(), password);
        userService.updateUser(user);
        System.out.println(student);
        request.setAttribute("update_success", "修改成功");
        if (session.getAttribute("student") != null) {
            session.removeAttribute("student");
        }
        session.setAttribute("student", student);
        return "student/student_main";
    }

    @RequestMapping("/insert_student")
    public String insertStudent(Student student, String password) {
        User user = new User(student.getStuID(), password, 0);
        userService.saveUser(user);
        System.out.println("开始导入学生信息");
        System.out.println(student);
        studentService.saveStudent(student);
        return "student/insert_success";
    }

    @RequestMapping("/projects")
    public String projects(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("projects") != null) {
            session.removeAttribute("projects");
        }
        List<Project> projects = projectService.findAllProjectOfUnselected();
        session.setAttribute("projects", projects);
        return "/student/student_projects";
    }

    @RequestMapping("/choose_project/{projectID}")
    public String chooseProject(@PathVariable("projectID") String projectID, HttpSession session) {
        Project project = projectService.findProjectByID(projectID);
        Student student = (Student) session.getAttribute("student");
        if (student.getProjectID() != null) {
            System.out.println("删除旧课题");
            Project oldProject = projectService.findProjectByID(student.getProjectID());
            oldProject.setUnselected();
            projectService.updateProject(oldProject);
        }
        System.out.println("选择课题");
        project.setSelected(student.getStuID());
        student.setProjectID(projectID);
        projectService.updateProject(project);
        studentService.updateStudent(student);
        session.removeAttribute("student");
        session.setAttribute("student", student);
        return "student/student_main";
    }
}
