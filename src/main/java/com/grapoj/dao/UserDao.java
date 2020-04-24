package com.grapoj.dao;

import com.grapoj.domain.user.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    
    @Select("select * from users where userID=#{userID}")
    public User findUserByID(String userID);

    //    保存账户信息
    @Insert("insert into users (userID, password,permission) " +
            "values (#{userID},#{password},#{permission})")
    public void saveUser(User user);

    //    删除账户信息
    @Delete("delete from users where userID=#{userID}")
    public void deleteUserByStuID(String userID);

    //    修改账户信息
    @Update("update users set password=#{password},permission=#{permission} where userID=#{userID}")
    public void updateUser(User user);

}
