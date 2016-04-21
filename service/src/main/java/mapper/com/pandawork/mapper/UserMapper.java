package com.pandawork.mapper;

import com.pandawork.common.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/*
 **
 * UserMapper
 *  Created by Wanliluo on 2016/3/23.
 */
public interface UserMapper {

    /**
     *添加用户
     * @Param user
     * @return user
     * @throws Exception
     **/
    public void newUser(@Param("user")User user) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delById(@Param("id")Integer id) throws Exception;

    /**
     * 更新用户信息
     * @param user
     * @throws Exception
     */
    public void update(@Param("user")User user) throws Exception;

    /**
     * 根据id查User
     * @param id
     * @return
     * @throws Exception
     */
    public User queryById(@Param("id")Integer id) throws Exception;

    /**
     * 根据userName查找用户
     * @param userName
     * @return
     * @throws Exception
     */
    public User queryByUserName(@Param("userName") String userName) throws Exception;

    /**
     * 判断用户是否存在
     * @param userName
     * @return
     * @throws Exception
     */
    public Integer checkUserName(@Param("userName") String userName) throws Exception;

    /**
     * 验证用户名和密码
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public Integer countByNAndPw(@Param("userName") String userName,
                                 @Param("password") String password) throws Exception ;

    /**
     * 获取用户列表
     * @return
     * @throws Exception
     */
    public List<User> listAll() throws Exception;

    /**
     * 检查登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public boolean checkLogin(@Param("userName") String userName,
                              @Param("password") String password) throws Exception ;

    /**
     * 动态查询用户
     * @param userName
     * @return
     * @throws Exception
     */
    public User selectUserCondition(@Param("userName") String userName) throws Exception;

}