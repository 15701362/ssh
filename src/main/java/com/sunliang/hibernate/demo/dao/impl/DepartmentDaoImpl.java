package com.sunliang.hibernate.demo.dao.impl;

import com.sunliang.hibernate.demo.dao.DepartmentDao;
import com.sunliang.hibernate.demo.entity.Department;
import com.sunliang.hibernate.demo.entity.Employee;
import com.sunliang.hibernate.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author sunliang
 * @desc 部门
 * @create 2017-12-15 17:26
 **/
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl implements DepartmentDao {

    @Override
    public Department findById(String id) {
        String departmentHql = "Select d from " + Department.class.getName() + " d "
                + " where d.deptNo= :deptNo ";
        Query<Department> departmentQuery = getSession().createQuery(departmentHql).setCacheable(true);
        departmentQuery.setParameter("deptNo", id);
        return departmentQuery.getSingleResult();
    }
}
