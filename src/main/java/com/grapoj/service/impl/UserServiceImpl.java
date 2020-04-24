package com.grapoj.service.impl;

import com.grapoj.dao.UserDao;
import com.grapoj.domain.user.User;
import com.grapoj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByID(String userID) {
        return userDao.findUserByID(userID);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserByStuID(String userID) {
        userDao.deleteUserByStuID(userID);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
