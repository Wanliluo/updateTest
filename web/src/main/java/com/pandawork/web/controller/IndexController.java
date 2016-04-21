package com.pandawork.web.controller;

import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * IndexController
 * Created by chant on 2016/3/23.
 */
@Controller
@RequestMapping(value = "")
@SessionAttributes("currentUser")
public class IndexController extends AbstractController {
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String toIndex(Model model) {
        return "login";
    }
}
