package com.nicklaus.bean;


import com.nicklaus.service.ProjectService;
import com.nicklaus.service.StyleService;
import com.nicklaus.service.UserService;
import com.nicklaus.service.impl.ProjectServiceImpl;
import com.nicklaus.service.impl.StyleServiceImpl;
import com.nicklaus.service.impl.UserServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@ManagedBean(name = "user")
@RequestScoped
@Entity
@Table(name = "user_table")
public class UserBean{

    @Transient
    private UserService userService = new UserServiceImpl();

    @Transient
    private String available;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private int uid;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_address")
    private String address;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_introduction")
    private String introduction;

    @Column(name = "u_experience")
    private String experience;

    @Column(name = "u_interest")
    private String interest;

    @Column(name = "u_skill")
    private String skill;

    @Column(name = "u_goal")
    private String goal;

    public UserBean(){}

    public String createAccount(){
        boolean flagUser = userService.create(this);
        if (flagUser){
            return "register_ok";
        }else{
            return null;
        }
    }

    public void isAvailable(){
        boolean flag = userService.findByUserName(username);
        if (flag){
            available = "This username has been registered!";
        }else{
            available = "This username is available!";
        }
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
