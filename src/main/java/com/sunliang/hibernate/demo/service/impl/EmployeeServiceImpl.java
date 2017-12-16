package com.sunliang.hibernate.demo.service.impl;

import com.sunliang.hibernate.demo.dao.EmployeeDao;
import com.sunliang.hibernate.demo.entity.Employee;
import com.sunliang.hibernate.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Throwable.class)
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Throwable.class)
    public Employee findById(Long empId) {
        return employeeDao.findById(empId);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Throwable.class)
    public void merge(Employee employee) {
        employeeDao.merge(employee);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Throwable.class)
    public void remove(Employee employee) {
        employeeDao.remove(employee);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Throwable.class)
    public void persist(Employee employee) {
        employeeDao.persist(employee);
    }
}
