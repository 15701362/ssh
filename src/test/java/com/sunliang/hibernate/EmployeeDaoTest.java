package com.sunliang.hibernate;

import com.sunliang.hibernate.demo.dao.EmployeeDao;
import com.sunliang.hibernate.demo.dao.impl.EmployeeDaoImpl;
import com.sunliang.hibernate.demo.entity.Employee;
import org.junit.Test;

import java.util.List;

/**
 * @author sunliang
 * @desc d
 * @create 2017-12-13 15:55
 **/
public class EmployeeDaoTest {
    private  EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Test
    public void testFindAll() {

        List<Employee> employees = employeeDao.findAll();
        for (Employee emp : employees) {
            System.out.println(emp.getEmpName());
        }
    }

    @Test
    public void test(){
        Employee employee = employeeDao.findById(7936L);
        System.out.println(employee.getEmpName());
        employee.setEmpName("aaaaa");
//        employeeDao.merge(employee);
        employeeDao.remove(employee);
//        Employee em2 = employeeDao.findById(7936L);
//        System.out.println(em2.getEmpName());
    }

    @Test
    public void testAdd(){
        Employee employee = new Employee();
        employee.setEmpId(7936L);
        employee.setEmpName("hahaha222");
        employeeDao.persist(employee);
    }
}
