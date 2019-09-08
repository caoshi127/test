package com.zzuli.library.controller;

import com.zzuli.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login/check")
    @ResponseBody
    public Map loginCheck(HttpServletRequest req) {
        String userIdStr = req.getParameter("userId");
        String passwordStr = req.getParameter("password");
//        System.out.println("LoginController.loginCheck" + "账号: " + userIdStr);
//        System.out.println("LoginController.loginCheck" + "密码" + passwordStr);
        // 记录登录状态和登录信息
        Map<String, String> result = new HashMap<>();

        if (userIdStr != null && !userIdStr.equals("") && passwordStr != null && !passwordStr.equals("")) {
            Map<String, Object> matchUser = loginService.matchUser(Long.parseLong(userIdStr), passwordStr);

            if (matchUser != null) {    // 匹配成功
                req.getSession().setAttribute("logged_in", "logged_in");    // 用户已登录成功
                if (matchUser.get("isAdmin") != null) {
                    // System.out.println("LoginController.loginCheck" + "是管理员登录了");
                    // System.out.println("LoginController.loginCheck      " + matchUser.get("isAdmin"));
                    req.getSession().setAttribute("admin", matchUser.get("isAdmin"));
                    result.put("stateCode", "1");       // 管理员登录
                    // result.put("msg", "管理员登录成功");
                }
                else if(matchUser.get("isReader") != null) {    // readerCard != null
                    // System.out.println("LoginController.loginCheck" + "读者登录");
                    // System.out.println("LoginController.loginCheck--" + matchUser.get("isReader"));
                    req.getSession().setAttribute("readerCard", matchUser.get("isReader"));     //
                    result.put("stateCode", "2");       // 读者登录
                    // result.put("msg", "读者登录成功");
                }
            }
            // 匹配失败, 说明账号或密码输入有误
            else {
                result.put("stateCode", "0");
            }
        }
        // 向前台响应登录状态及登录信息
        return result;
    }

    // 跳转到admin_main.jsp页面
    @RequestMapping("/admin_main.html")
    public ModelAndView toAdminMain() {
        return new ModelAndView("admin_main");
    }

    // 跳转到reader_main.jsp页面
    @RequestMapping("/reader_main.html")
    public ModelAndView toReaderMain() {
        return new ModelAndView("reader_main");
    }

    // 跳转到主页
    @RequestMapping("/login.html")
    public ModelAndView toLogin() {
        return new ModelAndView("login");
    }

}
