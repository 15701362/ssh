package com.sunliang.hibernate;

import com.sunliang.hibernate.demo.entity.Department;
import com.sunliang.hibernate.demo.entity.Employee;
import com.sunliang.hibernate.demo.service.DepartmentService;
import com.sunliang.hibernate.demo.service.EmployeeService;
import com.sunliang.hibernate.demo.utils.DataUtil;
import com.sunliang.hibernate.demo.utils.HibernateUtil;
import com.sunliang.utils.UuidUtils;
import javafx.application.Application;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author sunliang
 * @desc spring-hibernate整合
 * @create 2017-12-14 14:08
 **/
public class SpringTest {


    @Test
    public void testFindAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeServiceImpl");
        List<Employee> all = employeeService.findAll();
        for(Employee employee:all){
            System.out.println(employee.getEmpName());
        }
    }

    @Test
    public void testPersist(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeServiceImpl");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentServiceImpl");
        Department department = departmentService.findById("D10");


        // 创建瞬时状态对象
        Employee emp = new Employee();
        emp.setEmpNo("E-test");
        emp.setEmpName("Name==== " + UuidUtils.getUUID());
        emp.setJob("Coder");
        emp.setSalary(1000f);
        emp.setManager(null);
        emp.setHideDate(new Date());
        emp.setDepartment(department);

        employeeService.persist(emp);

    }

    @Test
    public  void testMerge(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeServiceImpl");
        Employee employee = employeeService.findById(7935L);
        employee.setEmpName("wahahah===");
        employeeService.merge(employee);
    }
    @Test
    public void testRemove(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-hibernate.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeServiceImpl");
        Employee employee = employeeService.findById(7936L);
        employeeService.remove(employee);
    }
}
