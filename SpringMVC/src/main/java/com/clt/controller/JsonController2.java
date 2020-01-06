package com.clt.controller;

import com.clt.pojo.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/json2")
public class JsonController2 {
    @RequestMapping("/m2")
        public String  comm(@RequestBody Comment com){
        System.out.println(com.getName()+com.getId());
        return  "girl";
    }
}
