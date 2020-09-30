package com.nicklaus.dao.impl;

import com.nicklaus.bean.Project;
import com.nicklaus.dao.ProjectDAO;
import com.nicklaus.util.JPAUtilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

    @Override
    public List<Project> findAll(int uid) {
        List<Project> projects = null;
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            String jpql = "from Project where uid = ?";
            Query query = emg.createQuery(jpql);
            query.setParameter(1,uid);
            projects = (List<Project>)query.getResultList();
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
        }finally {
            emg.close();
        }
        return projects;
    }

    @Override
    public Project find(int pid) {
        Project project = null;
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            project = emg.find(Project.class,pid);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
        }finally {
            emg.close();
        }
        return project;
    }

    @Override
    public void update(Project updateProject) {
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            emg.merge(updateProject);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
        }finally {
            emg.close();
        }
    }

    @Override
    public void create(Project project) {
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            emg.persist(project);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
        }finally {
            emg.close();
        }
    }
}
