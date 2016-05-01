package com.pandawork.web.controller;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * IndexController
 * Created by chant on 2016/3/23.
 */
@Controller
@RequestMapping(value = "")
@SessionAttributes("currentUser")
public class IndexController extends AbstractController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String toIndex() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(User user, Model model) {
        try {
            if (!userService.checkUserName(user.getUserName())) {
                model.addAttribute("message1", "用户名不存在");
                return "login";
            }
            if(!userService.countByNAndPw(user.getUserName(), user.getPassword())) {
                model.addAttribute("message2", "用户名或密码错误");
                return "login";
            }
            userService.checkLogin(user.getUserName(),user.getPassword());
            return "userInfo";
        } catch (SSException ee) {
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}
