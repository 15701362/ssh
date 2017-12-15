package com.sunliang.hibernate;

import com.sunliang.hibernate.demo.entity.Employee;
import com.sunliang.hibernate.demo.service.EmployeeService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
}
