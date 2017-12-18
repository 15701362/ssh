package com.sunliang.hibernate.demo.utils;

import com.sunliang.hibernate.demo.entity.Department;
import com.sunliang.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author sunliang
 * @desc 操作封装类
 * @create 2017-12-12 14:28
 **/
@Component
public class DataUtil {

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Throwable.class)
    public Long getMaxEmpId(Session session) {
        String hql = "Select max(e.empId) from " + Employee.class.getName() + " e ";
        Query<Number> query = session.createQuery(hql);
        Number value = query.getSingleResult();
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

}
