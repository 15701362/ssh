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

    /**
     * 根据empId 查询 Employee
     * @param empId
     * @return Employee
     */
    Employee findById(Long empId);

    /**
     * 更新
     * @param employee
     */
    void merge(Employee employee);

    /**
     * 删除
     * @param employee
     */
    void remove(Employee employee);

    /**
     * 添加
     * @param employee
     */
    void persist(Employee employee);
}
