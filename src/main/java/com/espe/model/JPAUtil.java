package com.espe.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE_UNIT";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory(){
        if(factory==null){
            factory= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutDown(){
        if(factory!=null){
            factory.close();
        }
    }
}