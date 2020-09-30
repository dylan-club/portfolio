package com.nicklaus.dao;

import com.nicklaus.bean.UserBean;

public interface UserDAO {

    /**
     * create a user account
     * @param userBean
     * @return
     */
    public boolean create(UserBean userBean);

    /**
     * find user by username
     * @param username
     * @return
     */
    public boolean findByUserName(String username);

    /**
     * find user by username and password
     * @param username
     * @param password
     * @return
     */
    public UserBean findByUsernameAndPassword(String username, String password);

    /**
     * update user information
     * @param loginUser
     * @return
     */
    public Boolean update(UserBean loginUser);
}
