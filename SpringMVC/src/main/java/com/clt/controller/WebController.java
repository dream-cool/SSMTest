package com.clt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("web")
public class WebController {


    @RequestMapping("/request")
    public String request(WebRequest webRequest){
        webRequest.getParameter("girl");
        return "girl";
    }

}
