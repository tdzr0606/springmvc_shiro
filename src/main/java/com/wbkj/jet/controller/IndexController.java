package com.wbkj.jet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        System.out.println(request.getSession().getAttribute("user"));
        return "test_jsp";
    }

    @RequestMapping(value = "/logout")
    public String logout()
    {
        request.getSession().removeAttribute("user");
        return "index_jsp";
    }


    @RequestMapping(value = "/test")
    public String testPage()
    {
        return "test_jsp";
    }


    @RequestMapping(value = "/unauthor")
    public String unauthorPage()
    {
        return "unauthor_jsp";
    }


    @RequestMapping(value = "/fail")
    public String failPage()
    {
        return "fail_jsp";
    }

    @RequestMapping(value = "/cas")
    public void cas()
    {
        System.out.println("cas");
    }
}
