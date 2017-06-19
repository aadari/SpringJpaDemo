package com.example.springjpademo.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class  AbstractDao
{

    @Autowired
    SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory)
    {
    	this.sessionFactory = sessionFactory;
    }

    protected Session getSession()
    {
    	try{
        return sessionFactory.getCurrentSession();
    	}
    	catch(HibernateException he)
    	{
    		return sessionFactory.openSession();
    	}
    }

    protected <T> void persist(T entity) {
    	getSession().persist(entity);
    }

    protected <T> void delete(T entity)
    {
        getSession().delete(entity);
    }
    
    protected <T> void update(T entity)
    {
    	getSession().update(entity);
    }

}