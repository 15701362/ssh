package com.sunliang.hibernate.demo.service.impl;

import com.sunliang.hibernate.demo.dao.UserDao;
import com.sunliang.hibernate.demo.entity.User;
import com.sunliang.hibernate.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sunliang
 * @desc 用户
 * @create 2018-01-22 16:41
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements UserService {

    @Resource(name = "userDaoImpl")
    public void setBaseDao(UserDao userDao) {
        super.setBaseDao(userDao);
    }
}
