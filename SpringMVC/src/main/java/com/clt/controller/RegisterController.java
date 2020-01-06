package com.clt.controller;

import com.clt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/reg")
@Controller
public class RegisterController {

    @RequestMapping("/check")
    @ResponseBody
    public Map<String,String> check(@RequestBody User user, Model model){
        model.addAttribute("user",user);
        Map<String ,String> map=new HashMap<>();
        String code ="2000";
        if(user.getName().equals("陈")){
            code="400";
        }
        map.put("code",code);
        System.out.println(user.getName());
        return map;
    }
}
