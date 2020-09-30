package com.nicklaus.dao;

import com.nicklaus.bean.Project;

import java.util.List;

public interface ProjectDAO {

    /**
     * find all projects of one user
     * @param uid
     * @return
     */
    public List<Project> findAll(int uid);

    /**
     * find target project by pid
     * @param pid
     * @return
     */
    public Project find(int pid);

    /**
     * update project detail
     * @param updateProject
     */
    public void update(Project updateProject);

    /**
     * create a new project
     * @param project
     */
    public void create(Project project);
}
