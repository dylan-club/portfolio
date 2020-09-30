package com.nicklaus.dao.impl;

import com.nicklaus.bean.UserBean;
import com.nicklaus.dao.UserDAO;
import com.nicklaus.util.JPAUtilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class UserDAOImpl implements UserDAO {
    @Override
    public boolean create(UserBean userBean) {

        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            emg.persist(userBean);
            ts.commit();
            return true;
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
            return false;
        }finally {
            emg.close();
        }
    }

    @Override
    public boolean findByUserName(String username) {
        EntityManager emg = null;
        EntityTransaction ts = null;
        boolean flag = false;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            String jpql = "select COUNT (uid)from UserBean where username = ?";
            Query query = emg.createQuery(jpql);
            int pos_username = 1;
            query.setParameter(pos_username,username);
            long user = (long)query.getSingleResult();
            if (user != 0L){
                flag = true;
            }else{
                flag = false;
            }
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
        }finally {
            emg.close();
        }

        return flag;
    }

    @Override
    public UserBean findByUsernameAndPassword(String username, String password) {
        UserBean user = null;
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            String jpql = "from UserBean where username = ? and password = ?";
            Query query = emg.createQuery(jpql);
            int pos_username = 1;
            int pos_password = 2;
            query.setParameter(pos_username,username);
            query.setParameter(pos_password,password);
            user = (UserBean) query.getSingleResult();

            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        }finally {
            emg.close();
        }

        return user;
    }

    @Override
    public Boolean update(UserBean loginUser) {
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            emg.merge(loginUser);
            ts.commit();
            return true;
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
            return false;
        }finally {
            emg.close();
        }
    }
}
