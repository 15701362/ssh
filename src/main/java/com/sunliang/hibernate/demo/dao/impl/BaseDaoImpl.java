package com.sunliang.hibernate.demo.dao.impl;

import com.sunliang.hibernate.demo.dao.BaseDao;
import com.sunliang.hibernate.demo.utils.DataUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunliang
 * @desc basedao
 * @create 2017-12-15 17:28
 **/
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataUtil dataUtil;

    /**
     * 获取和当前线程绑定的Seesion
     *
     * @return Session
     */
    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public DataUtil getDataUtil() {
        return dataUtil;
    }


}
