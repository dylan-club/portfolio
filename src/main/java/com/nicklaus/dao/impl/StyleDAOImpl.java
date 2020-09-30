package com.nicklaus.dao.impl;

import com.nicklaus.bean.Project;
import com.nicklaus.bean.StyleBean;
import com.nicklaus.dao.StyleDAO;
import com.nicklaus.util.JPAUtilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class StyleDAOImpl implements StyleDAO {
    @Override
    public void update(StyleBean styleBean) {
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            emg.merge(styleBean);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
        }finally {
            emg.close();
        }
    }

    @Override
    public StyleBean findByUid(int uid) {
        StyleBean styleBean = null;
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            String jpql = "from StyleBean where uid = ?";
            Query query = emg.createQuery(jpql);
            query.setParameter(1,uid);
            styleBean = (StyleBean) query.getSingleResult();
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        }finally {
            emg.close();
        }
        return styleBean;
    }

    @Override
    public void createByUid(int uid) {
        StyleBean styleBean = new StyleBean();
        styleBean.setUid(uid);
        EntityManager emg = null;
        EntityTransaction ts = null;
        try {
            emg = JPAUtilities.getEntityManager();
            ts = emg.getTransaction();
            ts.begin();
            emg.persist(styleBean);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
        }finally {
            emg.close();
        }
    }
}
