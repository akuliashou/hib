package com.acme;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.FactoryConfigurationError;

import javassist.bytecode.annotation.LongMemberValue;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ejb.EntityManagerImpl;

import com.acme.domain.User;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DOMConfigurator.configure("src/main/resources/log4j.xml");
//        Logger log = Logger.getLogger(Main.class);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManagerImpl em = (EntityManagerImpl) emf.createEntityManager();

        User user = em.find(User.class, 1l);
        em.close();
        emf.close();

        System.out.println(user.getGroups());

    }
}
