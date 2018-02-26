package com.sunliang.hibernate.demo.entity;

import org.compass.annotations.SearchableId;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author sunliang
 * @desc 会员
 * @create 2018-02-25 11:23
 **/
@Entity
public class Member {

    private Integer memberId;

    private Date createDate;

    private String username;

    private String password;

    @SearchableId
    @Id
    @Column(length = 32, nullable = true)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", createDate=" + createDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
