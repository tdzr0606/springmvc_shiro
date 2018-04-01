package com.wbkj.jet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * springmvc_shiro
 * IndexController
 *
 * @Author: 竺志伟
 * @Date: 2018-03-06 20:37
 */
@Controller
public class IndexController
{
    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/")
    public String defaultPage()
    {
        return "index_jsp";
    }

    @RequestMapping(value = "/login")
    public String login()
    {
        System.out.println("login:"+request.getSession().getAttribute("user"));
        return "test_jsp";
    }


    @RequestMapping(value = "/logout")
    public String logout()
    {
        request.getSession().removeAttribute("user");
        return "index_jsp";
    }


    @RequestMapping(value = "/webAdmin/test")
    public String testPage()
    {
        System.out.println("test:"+request.getSession().getAttribute("user"));
        return "test_jsp";
    }

}
