package com.acme;

import javax.persistence.Persistence;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.ReplicationMode;
import org.hibernate.collection.AbstractPersistentCollection;
import org.hibernate.ejb.EntityManagerImpl;

@Aspect
public class LazyAspect {

    @Around("execution(java.util.*  com.acme.domain.**.get*())")
    public Object lazy(ProceedingJoinPoint pjp) throws Throwable {
        Object res = pjp.proceed();
        if (res instanceof AbstractPersistentCollection && !((AbstractPersistentCollection)res).wasInitialized()) {
            EntityManagerImpl em = (EntityManagerImpl) Persistence.createEntityManagerFactory("jpa").createEntityManager();
            em.getSession().replicate(pjp.getThis(), ReplicationMode.LATEST_VERSION);
            res.equals(null);
            em.close();
        }
        return res;
    }
}
