package com.clt.controller;

import com.clt.pojo.Comment;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/ann")
public class AnnationController {

    @InitBinder("ann")
    public void init(WebDataBinder dataBinder){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,false));
    }

    @RequestMapping("/rb")
    @ResponseBody()
    @ParameterNames("value")
    public String rb(@ModelAttribute("ann") Comment comment,String value){
        System.out.println(value);
        System.out.println(comment.getId());
        System.out.println(comment.getContent());
        System.out.println(comment.getName());
        System.out.println(comment.getTime());
        return "ok";
    }

    @ModelAttribute
    public void init(Model model){
        Comment comment=new Comment();
        comment.setName("很好");
        System.out.println("初始化");
        model.addAttribute("comment",comment );
    }

    @RequestMapping("/login")
    public String comment(Model model){
        System.out.println(model.containsAttribute("comment"));
        System.out.println(model.containsAttribute("Comment"));
        return "girl";
    }



}
