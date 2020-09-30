package com.nicklaus.service.impl;

import com.nicklaus.bean.UserBean;
import com.nicklaus.dao.UserDAO;
import com.nicklaus.dao.impl.UserDAOImpl;
import com.nicklaus.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean create(UserBean userBean) {
        return userDAO.create(userBean);
    }

    @Override
    public boolean findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public UserBean findLoginUser(String username, String password) {
        return userDAO.findByUsernameAndPassword(username,password);
    }

    @Override
    public Boolean updateUser(UserBean loginUser) {
        return userDAO.update(loginUser);
    }
}
