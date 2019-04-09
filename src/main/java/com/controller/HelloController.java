package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author 一杯咖啡
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies.length != 0) {
            for (Cookie x : cookies) {
                if (x.getName().equals("name") || x.getName().equals("pwd")) {
                    if (x.getName().equals("name")) {
                        model.addAttribute("name", x.getValue());
                    }
                    if (x.getName().equals("pwd")) {
                        model.addAttribute("pwd", x.getValue());
                    }
                } else {
                    Cookie name = new Cookie("name", "zxx");
                    Cookie pwd = new Cookie("pwd", "1234");
                    name.setMaxAge(24 * 60 * 60);
                    pwd.setMaxAge(24 * 60 * 60);
                    response.addCookie(name);
                    response.addCookie(pwd);
                }
            }
        }
        request.getSession().setAttribute("loginUser", "zxx");
        return "index";
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String sayHello(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUser");
        return "hello spring mvc";
    }

    @RequestMapping(value = "/show")
    public String showPage(Model model) {
        model.addAttribute("name", "zxx");
        return "show";
    }

    @RequestMapping(value = "/show2")
    public ModelAndView showPage2(ModelAndView modelAndView) {
        modelAndView.addObject("page2", "show2");
        modelAndView.setViewName("show2");
        return modelAndView;
    }

    @RequestMapping(value = "/upload")
    public String upLoad(MultipartFile multipartFile) {
        try {
            multipartFile.transferTo(new File(multipartFile.getOriginalFilename()));
            return "/student/success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/files/success";
    }
}
