package com.zzuli.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 浏览器地址栏输入 : http://localhost:8080/login访问登录页面
 */
@Controller
public class BaseController {
    @RequestMapping("{page}")
    public String toPage(@PathVariable String page){
        return page;
    }

    // 用户退出登录
    @RequestMapping("/logout.html")
    public String logout(HttpServletRequest req) {
        req.getSession().invalidate();     // 销毁session
        return "redirect:/login.html";
    }

}
