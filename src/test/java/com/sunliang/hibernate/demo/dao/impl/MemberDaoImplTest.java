package com.sunliang.hibernate.demo.dao.impl;

import com.sunliang.hibernate.demo.dao.MemberDao;
import com.sunliang.hibernate.demo.entity.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class MemberDaoImplTest {

    SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Test
    public void login() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        MemberDao memberDao = (MemberDao) context.getBean("memberDaoImpl");
        Member member = memberDao.login("admin", "admin");
        System.out.println(member);
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
//        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//        Session session = sessionFactory.openSession();
//        String username = "admin";
//        String password = "admin";
//        String hql = "from Member m where m.username=:username and m.password=:password";
//
//        Member member = (Member)  session.createQuery(hql).setParameter("username", username).setParameter("password", password).uniqueResult();
//        System.out.println(member);
//        session.close();
    }

}