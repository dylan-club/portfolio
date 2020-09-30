package com.nicklaus.bean;


import com.nicklaus.service.ProjectService;
import com.nicklaus.service.impl.ProjectServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;


@ManagedBean(name = "project")
@RequestScoped
@Entity
@Table(name = "project_table")
public class Project implements Serializable {

    @Transient
    private ProjectService service = new ProjectServiceImpl();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int pid;

    @Column(name = "u_id")
    private int uid;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_key")
    private String key;

    @Column(name = "p_description")
    private String description;

    @Column(name = "p_summary")
    private String summary;

    @Column(name = "p_linkinfo")
    private String linkInfo;

    @Column(name = "p_linkdetail")
    private String linkDetail;

    public Project(){}

    public String create(){

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Map<String, Object> map = externalContext.getSessionMap();
        UserManagerBean userManager = (UserManagerBean)map.get("userManager");
        if (userManager != null){
            uid=userManager.getLoginUser().getUid();
            service.createProject(this);
        }
        return "home";
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLinkInfo() {
        return linkInfo;
    }

    public void setLinkInfo(String linkInfo) {
        this.linkInfo = linkInfo;
    }

    public String getLinkDetail() {
        return linkDetail;
    }

    public void setLinkDetail(String linkDetail) {
        this.linkDetail = linkDetail;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", description='" + description + '\'' +
                ", summary='" + summary + '\'' +
                ", linkInfo='" + linkInfo + '\'' +
                ", linkDetail='" + linkDetail + '\'' +
                '}';
    }
}
