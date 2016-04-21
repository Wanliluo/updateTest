package com.pandawork.common.entity;


import com.fasterxml.jackson.annotation.JsonAnyGetter;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * User实体
 * Created by chant on 2016/3/23.
 */
@Table(name = "t_user")
@Entity
public class User extends AbstractEntity {
    @Id
    private Integer id;

    @Column(name = "userName")
    private String userName;

    private Integer age;

    @Column(name = "password")
    private String password;

    @Column(name = "createdTime")
    private Date createdTime;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
