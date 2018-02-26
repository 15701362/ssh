package com.sunliang.hibernate.demo.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sunliang.hibernate.demo.entity.Member;
import com.sunliang.hibernate.demo.service.MemberService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author sunliang
 * @desc 登录
 * @create 2018-02-25 16:20
 **/
public class LoginAction extends ActionSupport {

    @Autowired
    protected MemberService memberService;

    /**
     * struts2会将action的所有带有get，set（这两个方法必须同时有）的属性自动的放入request域中
     */
    private String username;
    private String password;
    private Member member;

    //登录
    public String login() {
        member = memberService.login(username, password);
        if (member == null) {
            return ERROR;
        }
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
