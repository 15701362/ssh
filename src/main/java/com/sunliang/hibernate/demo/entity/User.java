package com.sunliang.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sunliang
 * @desc 用户
 * @create 2018-01-22 16:34
 **/
//@Entity
public class User extends BaseEntity {
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
