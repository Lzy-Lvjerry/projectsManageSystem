package com.grapoj.dao;

import com.grapoj.domain.Notice;
import com.grapoj.domain.Project;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao {

    @Select("select * from projects")
    public List<Project> findAllProject();

    @Select("select * from projects where hasSelected=0 and status=5")
    public List<Project> findAllProjectOfUnselected();

    @Select("select * from projects where teacherID=#{teaID}")
    public List<Project> findAllProjectByTeaID(String teaID);

    @Select("select * from projects where status=#{status}")
    public List<Project> findAllProjectByStatus(Integer status);

    @Select("select * from projects where status=#{status} and teacherID=#{teacherID}")
    public List<Project> findAllProjectByStatusAndTeacherID(@Param("status") Integer status,@Param("teacherID")String teacherID);

    @Select("select * from projects where status!=#{status} and teacherID=#{teacherID}")
    public List<Project> findAllProjectByNotStatusAndTeacherID(@Param("status") Integer status,@Param("teacherID")String teacherID);



    @Insert("insert into projects (title,detail,date,status) values (#{title},#{detail},#{date},#{status})")
    public void addProject(Project project);

    @Insert("insert into projects (title,detail,date,teacherID,status) values (#{title},#{detail}," +
            "#{date},#{teacherID},#{status})")
    public void pubProject(Project project);

    @Select("select * from projects where projectID=#{projectID}")
    public Project findProjectByID(String projectID);

    @Delete("delete from projects where projectID=#{projectID}")
    public void deleteProject(String projectID);

    @Update("update projects set title=#{title},detail=#{detail},date=#{date}," +
            "studentID=#{studentID},teacherID=#{teacherID},hasSelected=#{hasSelected}  where projectID=#{projectID}")
    public void updateProject(Project project);

    @Update("update projects set status=#{status} where projectID=#{projectID}")
    public void updateStatusByID(@Param("status") Integer status, @Param("projectID") String projectID);

    @Update("update projects set studentID=#{studentID} where projectID=#{projectID}")
    public void updateStudentID(@Param("projectID") String projectID,@Param("studentID") String studentID);
}
