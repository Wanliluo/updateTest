package com.pandawork.service.impl;

import com.pandawork.common.entity.User;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.mapper.UserMapper;
import com.pandawork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * UserServiceImpl
 * Created by Wanliluo on 2016/3/23.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void newUser(User user) throws SSException {
        Assert.isNotNull(user.getUserName(), NFException.UserNameNotNull);
        Assert.isNotNull(user.getPassword(), NFException.PasswordNotNull);
        try {
            user.setPassword(CommonUtil.md5(user.getPassword()));
            userMapper.newUser(user);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public boolean delById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return false;
        }
        try {
            userMapper.delById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(User user) throws SSException {
        try {
            userMapper.update(user);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public User queryById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return userMapper.queryById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User queryByUserName(String userName) throws SSException {
        if (!Assert.isNotNull(userName)){
            return null;
        }
        try {
            return userMapper.queryByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkUserName(String userName) throws SSException {
        try {
            return userMapper.checkUserName(userName) == 1 ? true:false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkLogin(String userName, String password) throws SSException {
        try {
            password = CommonUtil.md5(password);
            return userMapper.countByNAndPw(userName,password) >= 1? true:false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean countByNAndPw(String userName, String password) throws SSException {
        if (Assert.isNull(userName)&&Assert.isNull(password)) {
            return false;
        }
        try {
            password = CommonUtil.md5(password);
            return userMapper.countByNAndPw(userName, password) == 1? true:false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> listAll() throws SSException {
        try {
            return userMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public User selectUserCondition(String userName) throws SSException {
        try {
            return userMapper.selectUserCondition(userName);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}