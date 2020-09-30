package com.nicklaus.service.impl;

import com.nicklaus.bean.Project;
import com.nicklaus.dao.ProjectDAO;
import com.nicklaus.dao.impl.ProjectDAOImpl;
import com.nicklaus.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    ProjectDAO projectDAO = new ProjectDAOImpl();

    @Override
    public List<Project> findAll(int uid) {
        return projectDAO.findAll(uid);
    }

    @Override
    public Project find(int pid) {
        return projectDAO.find(pid);
    }

    @Override
    public void update(Project updateProject) {
        projectDAO.update(updateProject);
    }

    @Override
    public void createProject(Project project) {
        projectDAO.create(project);
    }

}
