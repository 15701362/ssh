package com.sunliang.hibernate.demo.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sunliang.hibernate.demo.entity.Member;

/**
 * @author sunliang
 * @desc 会员
 * @create 2018-02-25 13:16
 **/
public interface MemberDao extends BaseDao<Member,Integer> {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Member login(String username,String password);
}
