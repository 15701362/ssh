package com.sunliang.hibernate.demo.dao.impl;

import com.sunliang.hibernate.demo.dao.BaseDao;
import com.sunliang.hibernate.demo.dao.UserDao;
import com.sunliang.hibernate.demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author sunliang
 * @desc 用户
 * @create 2018-01-22 16:37
 **/

@Repository
public class UserDaoImpl extends BaseDaoImpl<User,Long> implements UserDao {

}
