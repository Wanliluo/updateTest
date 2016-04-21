package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserService
 * Created by chant on 2016/3/23.
 */
public interface UserService {

    /**
     *添加用户
     * @Param user
     * @return user
     * @throws Exception
     **/
    public void newUser(User user) throws SSException;

    /**
     * 根据用户名删除用户
     * @Param userName
     * @return
     * @throws Exception
     *
     * */
    public boolean delById(int id) throws SSException;

    /**
     * 更新
     * @param user
     * @throws SSException
     */
    public void update(User user) throws SSException;

    /**
     * 根据id查User
     * @param id
     * @return
     * @throws SSException
     */
    public User queryById(int id) throws SSException;

    /**
     * 根据userName查找用户
     * @param userName
     * @return
     * @throws Exception
     */
    public User queryByUserName(String userName) throws SSException;

    /**
     * 判断用户是否存在
     * @param userName
     * @return
     * @throws Exception
     */
    public boolean checkUserName(String userName) throws SSException;

    /**
     * 检查登录
     * @param userName
     * @param password
     * @return
     * @throws SSException
     */
    public boolean checkLogin(String userName, String password) throws SSException;

    /**
     * 验证用户名和密码
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public boolean countByNAndPw(String userName, String password) throws SSException ;

    /**
     * 获取用户列表
     * @return
     * @throws SSException
     */
    public List<User> listAll() throws SSException;

    /**
     * 动态查询用户
     * @param userName
     * @return
     * @throws SSException
     */
    public User selectUserCondition(String userName) throws SSException ;

}