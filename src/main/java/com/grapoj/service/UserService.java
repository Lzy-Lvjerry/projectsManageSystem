package com.grapoj.service;

import com.grapoj.domain.user.User;

public interface UserService {
    public User findUserByID(String userID);

    public void saveUser(User user);

    public void deleteUserByStuID(String userID);

    public void updateUser(User user);
}
