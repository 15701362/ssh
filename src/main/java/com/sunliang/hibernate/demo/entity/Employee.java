package com.sunliang.hibernate.demo.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sunliang
 * @desc 员工
 * @create 2017-12-12 9:59
 **/
@Entity
@Table(name = "EMPLOYEE", uniqueConstraints = { @UniqueConstraint(columnNames = { "EMP_NO" }) })
public class Employee {

    private Long empId;
    private String empNo;

    private String empName;
    private String job;
    private Employee manager;
    private Date hideDate;
    private Float salary;
    private byte[] image;

    private Department department;

    public Employee() {
    }

    public Employee(Long empId, String empName, String job, Employee manager, Date hideDate, Float salary, Float comm,
                    Department department) {
        this.empId = empId;
        this.empNo = "E" + this.empId;
        this.empName = empName;
        this.job = job;
        this.manager = manager;
        this.hideDate = hideDate;
        this.salary = salary;
        this.department = department;
    }

    @Id
    @Column(name = "EMP_ID")
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    @Column(name = "EMP_NO", length = 20, nullable = false)
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    @Column(name = "EMP_NAME", length = 50, nullable = false)
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Column(name = "JOB", length = 30, nullable = false)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MNG_ID")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Column(name = "HIRE_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getHideDate() {
        return hideDate;
    }

    public void setHideDate(Date hideDate) {
        this.hideDate = hideDate;
    }

    @Column(name = "SALARY", nullable = false)
    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Column(name = "IMAGE", length = 1111111, nullable = true)
    @Lob
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + manager +
                ", hideDate=" + hideDate +
                ", salary=" + salary +
                ", image=" + Arrays.toString(image) +
                ", department=" + department +
                '}';
    }

}
