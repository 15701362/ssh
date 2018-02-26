package com.sunliang.hibernate.demo.service.impl;

import com.sunliang.hibernate.demo.dao.MemberDao;
import com.sunliang.hibernate.demo.dao.UserDao;
import com.sunliang.hibernate.demo.entity.Member;
import com.sunliang.hibernate.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author sunliang
 * @desc 会员
 * @create 2018-02-25 13:20
 **/
@Service
public class MemberServiceImpl extends BaseServiceImpl<Member,Integer> implements MemberService {

    @Resource(name = "memberDaoImpl")
    public void setBaseDao(MemberDao memberDao) {
        super.setBaseDao(memberDao);
    }

    @Autowired
    public MemberDao memberDao;

    @Transactional
    @Override
    public Member login(String username, String password) {
        return memberDao.login(username,password);
    }
}
