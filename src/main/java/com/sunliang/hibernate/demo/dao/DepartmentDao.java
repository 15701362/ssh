package com.sunliang.hibernate.demo.dao;

import com.sunliang.hibernate.demo.entity.Department;

/**
 * @author sunliang
 * @desc 部门
 * @create 2017-12-15 17:25
 **/
public interface DepartmentDao {

    /**
     * 按id获得部门
     * @param id
     * @return
     */
    Department findById(String id);
}
