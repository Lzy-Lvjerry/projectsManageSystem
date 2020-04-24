package com.grapoj.dao;


import com.grapoj.domain.user.Administrator;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorDao {

    @Select("select * from administrators where adminID=#{adminID}")
    public Administrator findAdministratorByID(String adminID);

    //    保存账户信息
    @Insert("insert into administrators (adminID, name,phone, address) " +
            "values (#{adminID},#{name},#{phone},#{address})")
    public void saveAdministrator(Administrator administrator);

    //    删除账户信息
    @Delete("delete from administrators where adminID=#{adminID}")
    public void deleteAdministratorByStuID(String adminID);

    //    修改账户信息
    @Update("update administrators set name=#{name},address=#{address},phone=#{phone}," +
            "where adminID=#{adminID}")
    public void updateAdministrator(Administrator administrator);

}
