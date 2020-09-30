package com.nicklaus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilities {
    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("project");
    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
