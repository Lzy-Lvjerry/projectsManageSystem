package com.grapoj.dao;


import com.grapoj.domain.user.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    @Select("select * from students where yearClass=#{yearClass}")
    public List<Student> findAllStudentByYearClass(Integer yearClass);

    @Select("select * from students where stuID=#{stuID}")
    public Student findStudentByID(String stuID);

    //    保存账户信息
    @Insert("insert into students (stuID, name,gender,subject,department,age,address,phone) " +
            "values (#{stuID},#{name},#{gender},#{subject},#{department},#{age},#{address},#{phone})")
    public void saveStudent(Student student);

    //    删除账户信息
    @Delete("delete from students where stuID=#{stuID}")
    public void deleteStudentByStuID(String stuID);

    //    修改账户信息
    @Update("update students set name=#{name},gender=#{gender},subject=#{subject}," +
            "department=#{department},age=#{age},address=#{address},phone=#{phone}," +
            "projectID=#{projectID} where stuID=#{stuID}")
    public void updateStudent(Student student);

    @Update("update students set projectID=#{projectID} where stuID=#{stuID}")
    public void updateStudentProjectID(@Param("stuID") String stuID, @Param("projectID") String projectID);

}
