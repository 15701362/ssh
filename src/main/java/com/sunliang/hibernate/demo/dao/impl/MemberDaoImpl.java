package com.sunliang.hibernate.demo.dao.impl;

import com.sunliang.hibernate.demo.dao.MemberDao;
import com.sunliang.hibernate.demo.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunliang
 * @desc 会员
 * @create 2018-02-25 13:17
 **/
@Repository
public class MemberDaoImpl extends BaseDaoImpl<Member,Integer> implements MemberDao {

    @Transactional
    @Override
    public Member login(String username, String password) {
        String hql = "from Member m where m.username=:username and m.password=:password";
        Member member = (Member) getSession().createQuery(hql).setParameter("username", username).setParameter("password", password).uniqueResult();
        return member;
    }
}
