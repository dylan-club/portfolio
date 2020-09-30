package com.nicklaus.bean;


import com.nicklaus.service.ProjectService;
import com.nicklaus.service.impl.ProjectServiceImpl;
import com.nicklaus.util.ObjectUtilities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "projectManager")
@SessionScoped
public class ProjectManagerBean implements Serializable {

    private ProjectService service = new ProjectServiceImpl();

    private List<Project> projects;

    private Project pageProject;

    public ProjectManagerBean(){}

    public void findPageProject(int id){
        pageProject = service.find(id);
    }

    public List<Project> getProjects() {
        UserManagerBean userManager = (UserManagerBean)ObjectUtilities.getSessionAttribute("userManager");
        if (userManager != null){
            projects = service.findAll(userManager.getLoginUser().getUid());
        }else{
            projects = new ArrayList<Project>();
        }
        return projects;
    }

    public Project getPageProject() {
        return pageProject;
    }

    public String updateProject(){
        service.update(pageProject);
        findPageProject(pageProject.getPid());
        return "project";
    }
}
