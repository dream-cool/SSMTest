package com.clt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/a")
public class Hello {

    @RequestMapping("/z")
    public String forward(Model model, WebRequest webRequest){
        System.out.println("转发");
        model.addAttribute("args","成功");
//        if(webRequest.getParameter("girl")==""){
//            System.out.println("1");
//        }
//        else if(webRequest.getParameter("girl")==null){
//            System.out.println("2");
//        }
//        else  System.out.println(webRequest.getParameter("girl"));


        return "girl";
    }

    @RequestMapping("/c")
    public String redire(Model model){
        System.out.println("重定向");
        model.addAttribute("args2","失败");
        return  "girl";
    }

    @RequestMapping("s")
    public String session(HttpSession session){
        System.out.println(session.getAttribute("args"));
        return "forward";
    }





}
