package com.pandawork.test;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chant on 2016/3/26.
 */
public class UserServiceTest extends AbstractTestCase {

    @Autowired
    UserService userService;

    @Test
    public void testNewUser() throws SSException {
        User user = new User();
        user.setUserName("777");
        user.setPassword("888");
        userService.newUser(user);
        System.out.println("13");
    }

    @Test
    public void testDelUserByUserName() throws SSException {
        User user = new User();
        user.setId(77);
        userService.delById(user.getId());
        System.out.println("16");
    }

    @Test
    public void testUpdate() throws SSException {
        User user = new User();
        user.setUserName("11");
        user.setPassword("666");
        user.setId(55);
        userService.update(user);
        System.out.println("12");
    }

    @Test
    public void testQueryById() throws SSException {
        System.out.println(userService.queryById(1).getUserName());
    }

    @Test
    public void testQueryByUserName() throws SSException {
        System.out.println(userService.queryByUserName("1").getPassword());
    }

    @Test
    public void testCheckUserName() throws SSException {
        if (userService.checkUserName("111")) {
            System.out.print("用户名存在");
        }else{
            System.out.print("用户不存在");
        }
    }

    @Test
    public void testCheckLogin() throws SSException {
        User user = new User();
        user.setUserName("111");
        user.setPassword("666");
        if(userService.checkLogin(userName,password)) {
            System.out.print("yyyyyyy");
        }
    }

    @Test
    public void testCountByUserNameAndPassword() throws SSException {
        System.out.print(userService.countByNAndPw("罗万理","帅帅帅"));
    }

    @Test
    public  void testListAll() throws SSException {
        System.out.print(userService.listAll().get(1).getUserName());
    }

    @Test
    public void testSelectUser() throws SSException {
        List<UserDto> list = Collections.emptyList();
        list=userService.selectUser(userDto);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getContent());
        }
    }
}