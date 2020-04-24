package com.grapoj.controller;


import com.grapoj.domain.user.Administrator;
import com.grapoj.domain.user.Student;
import com.grapoj.domain.user.Teacher;
import com.grapoj.domain.user.User;
import com.grapoj.service.AdministratorService;
import com.grapoj.service.StudentService;
import com.grapoj.service.TeacherService;
import com.grapoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdministratorService administratorService;

    @RequestMapping("/login")
    public String login(@RequestParam String userID, @RequestParam String password,
                        HttpSession session, HttpServletRequest request) {
        System.out.println("开始登录");
        User user = userService.findUserByID(userID);
        System.out.println(user.getUserID());
        if (user.getPassword().equals(password)) {
            if (session.getAttribute("user") != null) {
                session.invalidate();
                request.setAttribute("has_logged_error", "已注销当前用户，请重新登录");
                return "/login/login_main";
            }
            session.setAttribute("user", user);
            int permission = user.getPermission();
            if (permission == 0) {
                Student student = studentService.findStudentByID(userID);
                session.setAttribute("student", student);
                System.out.println(student.getName());
                System.out.println("登录成功---学生");
                return "redirect:/student/main.html";
            } else if (permission == 1) {
                Teacher teacher = teacherService.findTeacherByID(userID);
                session.setAttribute("teacher", teacher);
                System.out.println(teacher.getName());
                System.out.println("登录成功---教师");
                return "redirect:/teacher/main.html";
            } else if (permission == 3) {
                Teacher teacher = teacherService.findTeacherByID(userID);
                session.setAttribute("teacher", teacher);
                System.out.println(teacher.getName());
                System.out.println("登录成功---专业负责人");
                return "redirect:/teacher/main.html";
            } else if (permission == 4) {
                Teacher teacher = teacherService.findTeacherByID(userID);
                session.setAttribute("teacher", teacher);
                System.out.println(teacher.getName());
                System.out.println("登录成功---院长");
                return "redirect:/teacher/main.html";
            } else if (permission == 2) {
                Administrator administrator = administratorService.findAdministratorByID(userID);
                session.setAttribute("administrator", administrator);
                System.out.println(administrator.getName());
                System.out.println("登录成功---管理员");
                return "redirect:/administrator/main.html";

            } else {
                return "redirect:/login/login_main";
            }
        } else {
            request.setAttribute("password_error", "用户名或密码不正确");
            System.out.println("账号或密码错误");
            return "redirect:/login/login_main";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        request.setAttribute("logout_success", "注销成功");
        return "login/login_main";
    }
}
