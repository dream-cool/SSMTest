package com.clt.controller;

import com.clt.pojo.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("comment")
public class ByeController {
    @RequestMapping("/bye")
    public String bye(Model model){
        model.addAttribute("model","md");
        return  "girl";
    }

    @RequestMapping("/addcomment")
    @ResponseBody
    public List<Comment>  addcomment(){
        List<Comment> comments =new ArrayList<>();
        Comment comment=new Comment();
        Comment comment1=new Comment();
        comment.setId(1);
        comment.setName("鞋子");
        comment.setContent("不好");
        comment.setTime(new Date());
        comment1.setId(12);
        comment1.setName("喜欢就够了");
        comment1.setContent("师傅告诉了");
        comment1.setTime(new Date());
        comments.add(comment);
        comments.add(comment1);
        return  comments;
    }
}
