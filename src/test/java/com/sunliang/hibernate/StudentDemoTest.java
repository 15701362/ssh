package com.sunliang.hibernate;

import com.sunliang.hibernate.demo.entity.Department;
import com.sunliang.hibernate.demo.entity.Employee;
import com.sunliang.hibernate.demo.utils.DataUtil;
import com.sunliang.hibernate.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author sunliang
 * @desc 课堂演示
 * @create 2017-12-13 14:43
 **/
public class StudentDemoTest {

    /**
     * 查询所有
     */
    @Test
    public void testQueryAll() {
        Session session = HibernateUtil.getSession();
        try {
            System.out.println("come into");
            session.getTransaction().begin();
//            String hql2 = "from Employee e order by e.empName,e.empNo";
            String hql = "Select e from " + Employee.class.getName() + " e "
                    + " order by e.empName, e.empNo ";
            Query<Employee> query = session.createQuery(hql);
            //执行查询.
            List<Employee> employees = query.getResultList();

            for (Employee emp : employees) {
                System.out.println("Emp: " + emp.getEmpNo() + " : "
                        + emp.getEmpName());
            }
            // 提交事务.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 事务回滚.
            session.getTransaction().rollback();
        }

    }

    /**
     * 查询唯一结果
     */
    @Test
    public void testUniqueResult() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            System.out.println("222");
            session.getTransaction().begin();
            String departmentHql = "Select d from " + Department.class.getName() + " d "//
                    + " where d.deptNo= :deptNo ";
            Query<Department> departmentQuery = session.createQuery(departmentHql).setCacheable(true);
            departmentQuery.setParameter("deptNo", "D10");
            Department department = departmentQuery.getSingleResult();

            Set<Employee> employees = department.getEmployees();
            for (Employee emp : employees) {
                System.out.println("department 中的 emp name:" + emp.getEmpName());
            }

            String employeeHql = "Select e from " + Employee.class.getName() + " e "
                    + " where e.empId= :empId ";
            Query<Employee> employeeQuery = session.createQuery(employeeHql);
            employeeQuery.setParameter("empId", 7839L);
            Employee employee = employeeQuery.getSingleResult();

            System.out.println("emp name:" + employee.getEmpName());
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().commit();
        }
    }

    /**
     * 添加数据
     */
    @Test
    public void testPersist(){

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.getCurrentSession();
        Department department = null;
        Employee emp = null;
        try {
            System.out.println("123");
            session.getTransaction().begin();

            Long maxEmpId = DataUtil.getMaxEmpId(session);
            Long empId = maxEmpId + 1;

            //获得持久状态的对象.
            department = DataUtil.findDepartment(session, "D10");

            // 创建瞬时状态对象
            emp = new Employee();
            emp.setEmpId(empId);
            emp.setEmpNo("E" + empId);
            emp.setEmpName("Name==== " + empId);
            emp.setJob("Coder");
            emp.setSalary(1000f);
            emp.setManager(null);
            emp.setHideDate(new Date());
            emp.setDepartment(department);

            /*使用持久化（..）
            现在，“emp”是由Hibernate管理的。
            它具有持久状态。
            此时没有使用DB的操作。*/
            session.persist(emp);


            /*在这个步骤中，数据被推送到数据库。
            执行INSERT语句。*/
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        /*会话结束后（提交、回滚、关闭）
        对象“EMP”，“部门”变成了游离态。
        不在受session的控制*/
        System.out.println("Emp No: " + emp.getEmpNo());
    }
}
