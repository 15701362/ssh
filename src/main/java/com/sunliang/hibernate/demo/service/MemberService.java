package com.sunliang.hibernate.demo.service;

import com.sunliang.hibernate.demo.entity.Member;

/**
 * @author sunliang
 * @desc 会员
 * @create 2018-02-25 13:19
 **/
public interface MemberService extends BaseService<Member,Integer> {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Member login(String username,String password);
}
