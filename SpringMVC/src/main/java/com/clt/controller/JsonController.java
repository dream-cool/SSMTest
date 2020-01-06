package com.clt.controller;

import com.clt.pojo.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.*;

@Controller
@RequestMapping("/json")
public class JsonController {
    @RequestMapping("/m1")
    @ResponseBody
    public Comment comm(){
        Comment com =new Comment();
        com.setName("很好");
        com.setId(1);
        return  com;
    }

    @RequestMapping("/m2")
    @ResponseBody
    public Comment mapp(){
//        Map<String,Date> map=new HashMap<>();
        Comment comment=new Comment();
        comment.setTime(new Date());
        System.out.println(comment.getTime());
//        map.put("time",comment.getTime());
        return  comment;
    }

    @RequestMapping("/m3")
    @ResponseBody
    public Comment[] coms(){
        Comment com1=new Comment();
        Comment com2=new Comment();
        com1.setId(1);
        com1.setName("好");
        com2.setId(2);
        com2.setName("坏");
        return  new Comment[]{com1,com2};
    }

    @RequestMapping("/m4")
    @ResponseBody
    public List<Map<String,String>> lm(){
        Map<String,String> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        map1.put("name","好");
        map1.put("id","1");
        map2.put("name","坏");
        map2.put("id","2");
        List<Map<String,String>> list=new ArrayList<>();
        list.add(map1);
        list.add(map2);
        return list;
    }

}
