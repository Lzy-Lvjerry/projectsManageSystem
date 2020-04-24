package com.grapoj.controller;


import com.grapoj.domain.Project;
import com.grapoj.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.grapoj.tool.tools;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.grapoj.tool.tools.getCurrentTime;

@Controller
@RequestMapping("/project")
public class ProjectController {


    @Autowired
    private ProjectService projectService;


    @RequestMapping("/add")
    public String addProject(String title, String detail, HttpServletRequest request){
        String currentDate = tools.getCurrentDate();
        System.out.println("添加毕设...");
        Project project = new Project(title,detail,currentDate);
//        5表示为管理员直接添加的，未经审核流程
        project.setStatus(5);
        projectService.addProject(project);
        request.setAttribute("add_success","添加成功");

        return "redirect:/project/project_main.html";
    }



    @RequestMapping(value="project_main.html",method = RequestMethod.GET)
    public String main(HttpSession session, HttpServletRequest request){
        if(session.getAttribute("projects")!=null){
            session.removeAttribute("projects");
        }
        List<Project> projects = projectService.findAllProject();
        session.setAttribute("projects",projects);
        return "/project/project_main";
    }



    @RequestMapping("/detail/{projectID}")
    public String detail(@PathVariable("projectID")String projectID,HttpSession session){

        Project project = projectService.findProjectByID(projectID);
        System.out.println("查找毕设...");
        System.out.println(project);
        session.setAttribute("project",project);

        return "/project/project_detail";
    }
    
    @RequestMapping("/delete/{projectID}")
    public String delete(@PathVariable (name = "projectID")String projectID){
        System.out.println("删除课题...");
        System.out.println(projectID);
        projectService.deleteProject(projectID);
        return "redirect:/project/project_main.html";
    }

    @RequestMapping("/update/{projectID}")
    public String update(@PathVariable (name = "projectID")String projectID,HttpSession session){
        System.out.println("更新课题...");
        Project project = projectService.findProjectByID(projectID);
        System.out.println(project);
        session.setAttribute("project",project);
        return "/project/project_update";
    }
    @RequestMapping("/update/commit")
    public String updateCommit(String title,String detail,HttpSession session){
        Project project = (Project)session.getAttribute("project");
        project.setTitle(title);
        project.setTitle(detail);
        project.setDate(getCurrentTime());
        System.out.println(project);
        projectService.updateProject(project);
        return "redirect:/project/project_main.html";
    }
}
