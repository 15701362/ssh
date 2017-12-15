package com.sunliang.hibernate.demo.dao.impl;

import com.sunliang.hibernate.demo.dao.EmployeeDao;
import com.sunliang.hibernate.demo.entity.Employee;
import com.sunliang.hibernate.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunliang
 * @desc 实现类
 * @create 2017-12-13 15:52
 **/
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

//    private Session session = HibernateUtil.getSession();

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取和当前线程绑定的Seesion
     * @return Session
     */
    private Session getSession()
    {
        return sessionFactory.openSession();
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.openSession();
        List<Employee> employees = new ArrayList<Employee>();
        String hql = "from " + Employee.class.getName()  +" e"+" order by e.empName,e.empNo";
        Query<Employee> query = session.createQuery(hql);
        //执行查询.
        employees = query.getResultList();
        return  employees;
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
        try {
            getSession().getTransaction().begin();
            getSession().merge(employee);
            getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
        }
    }

    @Override
    public void remove(Employee employee) {
        try {
            getSession().getTransaction().begin();
            getSession().remove(employee);
            getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
        }
    }

    @Override
    public void persist(Employee employee) {
        try {
            getSession().getTransaction().begin();
            getSession().persist(employee);
            getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
        }
    }
}
