package com.sunliang.hibernate.demo.service.impl;

import com.sunliang.hibernate.demo.entity.Member;
import com.sunliang.hibernate.demo.service.MemberService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class MemberServiceImplTest {

    @Test
    public void login() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        MemberService memberService = (MemberService) context.getBean("memberServiceImpl");
        Member m = memberService.login("admin", "admin");
        System.out.println(m);
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        MemberService memberService = (MemberService) context.getBean("memberServiceImpl");
        List<Member> allList = memberService.getAllList();
        for (Member member :
                allList) {
            System.out.println(member);
        }
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        MemberService memberService = (MemberService) context.getBean("memberServiceImpl");
        Long totalCount = memberService.getTotalCount();
        System.out.println(totalCount);
    }

}