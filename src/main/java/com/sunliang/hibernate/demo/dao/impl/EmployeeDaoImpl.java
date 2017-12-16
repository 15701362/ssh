package com.sunliang.hibernate.demo.dao.impl;

import com.sunliang.hibernate.demo.dao.EmployeeDao;
import com.sunliang.hibernate.demo.entity.Employee;
import com.sunliang.hibernate.demo.utils.DataUtil;
import com.sunliang.hibernate.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunliang
 * @desc 实现类
 * @create 2017-12-13 15:52
 **/
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao {


    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<Employee>();
        String hql = "from " + Employee.class.getName() + " e" + " order by e.empName,e.empNo";
        Query<Employee> query = getSession().createQuery(hql);
        //执行查询.
        employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(Long empId) {
        String hql = "from " + Employee.class.getName() + " e "
                + " where e.empId= :empId ";
        Query<Employee> employeeQuery = getSession().createQuery(hql);
        employeeQuery.setParameter("empId", empId);
        return employeeQuery.getSingleResult();
    }

    @Override
    public void merge(Employee employee) {
        getSession().merge(employee);
    }

    @Override
    public void remove(Employee employee) {
        getSession().remove(employee);
    }

    @Override
    public void persist(Employee employee) {
        if(employee.getEmpId()==null){
            Long maxEmpId =  getDataUtil().getMaxEmpId(getSession());
            Long empId = maxEmpId + 1;
            employee.setEmpId(empId);
        }
        getSession().persist(employee);
    }
}
