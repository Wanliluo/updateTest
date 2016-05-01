package com.pandawork.common.dto;

/**
 * Description:动态查询用户dto
 * Author: Wanliluo
 * Date: 2016/4/23
 * Time: 15:28
 */
public class UserDto {

    private Integer id;

    //用户名
    private String userName;

    //性别
    private String sex;

    //用户年龄最大值
    private Integer maxAge;

    //用户年龄最小值
    private Integer minAge;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    public Integer getMaxAge() { return maxAge; }

    public void setMaxAge(Integer maxAge) { this.maxAge = maxAge; }

    public Integer getMinAge() { return minAge; }

    public void setMinAge(Integer minAge) { this.minAge = minAge; }
}


