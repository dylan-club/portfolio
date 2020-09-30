package com.nicklaus.bean;

import com.nicklaus.service.UserService;
import com.nicklaus.service.impl.UserServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "userManager")
@SessionScoped
public class UserManagerBean implements Serializable {

    private UserService service = new UserServiceImpl();

    private UserBean loginUser;

    private String username;

    private String password;

    private String loginError;

    public UserManagerBean(){}

    public UserBean getLoginUser() {
        return loginUser;
    }

    public String login(){
        loginUser = service.findLoginUser(username,password);

        if (loginUser == null){
            loginError = "Incorrect username or password.";
            return null;
        }else{
            loginError = "";
            return "home";
        }
    }

    public String updateLoginUser(){
        Boolean flag = service.updateUser(loginUser);
        if (flag){
            return "home";
        }else{
            return null;
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginError() {
        return loginError;
    }
}
