package com.sunliang.hibernate.demo.service.impl;

import com.sunliang.hibernate.demo.dao.EmployeeDao;
import com.sunliang.hibernate.demo.entity.Employee;
import com.sunliang.hibernate.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunliang
 * @desc service 员工
 * @create 2017-12-14 14:06
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
