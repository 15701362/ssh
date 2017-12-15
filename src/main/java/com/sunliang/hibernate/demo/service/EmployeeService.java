package com.sunliang.hibernate.demo.service;

import com.sunliang.hibernate.demo.entity.Employee;

import java.util.List;
/**
 * @author sunliang
 * @desc 员工
 * @create 2017-12-12 9:58
 **/
public interface EmployeeService {

    /**
     * 查询全部
     * @return  List<Employee>
     */
    List<Employee> findAll();
}
