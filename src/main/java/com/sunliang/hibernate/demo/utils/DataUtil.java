package com.sunliang.hibernate.demo.utils;

import com.sunliang.hibernate.demo.entity.Department;
import com.sunliang.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;


/**
 * @author sunliang
 * @desc 操作封装类
 * @create 2017-12-12 14:28
 **/
public class DataUtil {

    public static Department findDepartment(Session session, String deptNo) {

            String sql = "Select d from " + Department.class.getName() + " d "
                    + " Where d.deptNo = :deptNo";
            Query<Department> query = session.createQuery(sql);
            query.setParameter("deptNo", deptNo);
        return query.getSingleResult();
    }

    public static Long getMaxEmpId(Session session) {
        String sql = "Select max(e.empId) from " + Employee.class.getName() + " e ";
        Query<Number> query = session.createQuery(sql);
        Number value = query.getSingleResult();
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

    public static Employee findEmployee(Session session, String empNo) {
        String sql = "Select e from " + Employee.class.getName() + " e "
                + " Where e.empNo = :empNo";
        Query<Employee> query = session.createQuery(sql);
        query.setParameter("empNo", empNo);
        return query.getSingleResult();
    }

}
