package com.sunliang.hibernate.demo.service.impl;

import com.sunliang.hibernate.demo.dao.DepartmentDao;
import com.sunliang.hibernate.demo.entity.Department;
import com.sunliang.hibernate.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunliang
 * @desc 部门
 * @create 2017-12-16 10:39
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Throwable.class)
    public Department findById(String id) {
        return departmentDao.findById(id);
    }
}
