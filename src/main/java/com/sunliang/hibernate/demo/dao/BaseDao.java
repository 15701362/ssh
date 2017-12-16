package com.sunliang.hibernate.demo.dao;

import com.sunliang.hibernate.demo.utils.DataUtil;
import org.hibernate.Session;

/**
 * @author sunliang
 * @desc 基类
 * @create 2017-12-15 17:27
 **/
public interface BaseDao {
    /**
     * 获得session
     * @return
     */
    Session getSession();

    DataUtil getDataUtil();
}
