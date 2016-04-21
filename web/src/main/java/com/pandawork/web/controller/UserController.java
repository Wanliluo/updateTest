package com.pandawork.web.controller;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

/**
 * UserController
 * user:WanliLuo
 * date:2016/3/31
 * time:12:41
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends AbstractController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUser(Model model) {
        try {
            List<User> list = Collections.emptyList();
            list=userService.listAll();
            model.addAttribute("userList", list) ;
            return "userList";
        } catch (SSException ee){
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

   /* @RequestMapping(value = "/delete/{userName}" ,method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userName") String userName,Model model)*/

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delUser(@RequestParam("id")int id, RedirectAttributes redirectAttributes) {
        try {
            if (userService.delById(id)) {
                redirectAttributes.addFlashAttribute("message", "成功删除!");
            }
            return "redirect:/user/list";
        } catch (SSException ee) {
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(){
        return "add";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newUser(User user, @RequestParam("password2")String password2, RedirectAttributes redirectAttributes) throws SSException {
        try {
            if (Assert.isNull(user.getUserName())||Assert.isNull(user.getPassword())) {
                redirectAttributes.addFlashAttribute("message", "用户名和密码不能为空");
                return "redirect:/user/add";
            }
            if (userService.checkUserName(user.getUserName())) {
                redirectAttributes.addFlashAttribute("message", "用户名已经存在");
                return "redirect:/user/add";
            }
            if (!user.getPassword().equals(password2)) {
                redirectAttributes.addFlashAttribute("message", "密码不一致");
                return "redirect:/user/add";
            }
            userService.newUser(user);
            redirectAttributes.addFlashAttribute("message", "添加成功!");
            return "redirect:/user/list";
        } catch (SSException ee) {
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/change/{id}", method = RequestMethod.GET)
    public String toChange(@PathVariable("id")int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", id);
        return "change";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(User user,
                         @PathVariable("id")int id,
                         @RequestParam(value="newUserName")String newUserName,
                         @RequestParam(value="newAge")int newAge,
                         @RequestParam(value="newPassword")String newPassword,
                         @RequestParam(value="newPassword2")String newPassword2, Model model) throws SSException {
        try {
            if (!userService.checkUserName(user.getUserName())) {
                model.addAttribute("message", "用户名不存在");
                return "change";
            }
            if(!userService.countByNAndPw(user.getUserName(), user.getPassword())) {
                model.addAttribute("message", "用户名或密码错误");
                return "change";
            }
            if (Assert.isNull(newUserName)||Assert.isNull(newPassword)) {
                model.addAttribute("message", "新用户名和密码不能为空");
                return "change";
            }
            if (!newPassword.equals(newPassword2)) {
                model.addAttribute("message", "新密码不一致");
                return "change";
            }
            user.setId(id);
            user.setUserName(newUserName);
            user.setAge(newAge);
            user.setPassword(CommonUtil.md5(newPassword));
            userService.update(user);
            return "redirect:/user/list";
        } catch (SSException ee) {
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}