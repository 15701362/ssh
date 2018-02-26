package com.sunliang.hibernate.demo.entity;

import com.sunliang.hibernate.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        Member member = (Member)context.getBean("Member");
        System.out.println(member);
    }
}