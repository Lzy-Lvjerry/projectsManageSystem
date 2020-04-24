package com.grapoj.dao;

import com.grapoj.domain.user.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao {

    @Select("select * from teachers where teaID=#{teaID}")
    public Teacher findTeacherByID(String teaID);

    //    保存账户信息
    @Insert("insert into teachers (teaID, name,gender,position,department,age,address,phone) " +
            "values (#{teaID},#{name},#{gender},#{position},#{department},#{age},#{address},#{phone})")
    public void saveTeacher(Teacher teacher);

    //    删除账户信息
    @Delete("delete from teachers where teaID=#{teaID}")
    public void deleteTeacherByStuID(String teaID);

    //    修改账户信息
    @Update("update teachers set name=#{name},gender=#{gender},position=#{position}," +
            "department=#{department},age=#{age},address=#{address},phone=#{phone}," +
            "projectID=#{projectID} where teaID=#{teaID}")
    public void updateTeacher(Teacher teacher);
    
}
