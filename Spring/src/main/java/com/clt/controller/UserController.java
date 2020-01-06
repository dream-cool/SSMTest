package com.clt.controller;

import com.clt.pojo.User;
import com.clt.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired()
     private UserService userService;

    @RequestMapping("/login")
    public String login(User user , HttpSession session,Model model){
        User u=userService.selectLogin(user);
        if(u!=null){
            session.setAttribute("ul",u);
            System.out.println(session.getId());
            model.addAttribute("msg", u.getPassWord());
            return "success";
        }
        else
            return "fail";
    }

    @RequestMapping("/logincheck")
    @ResponseBody
    public Map<String,String> logincheck(@RequestBody  User user ){
        Map<String,String> map =new HashMap<>();
        String code="2000";
        User u=userService.selectLogin(user);
        if(u==null){
//            密码或用户名错误
            code="400";
        }
        if (user.getPassWord()==""||user.getPassWord()==null){
            code="500";
        }
        map.put("code",code);
        return map;
    }

    @RequestMapping("/register")
    public String register(User user ,HttpSession session){
        user.setRegTime(new Date());
        user.setLastLoginTime(new Date());
        boolean flag=userService.insertUser(user);
        if(flag){
            session.setAttribute("ur" ,user);
            return "success";
        }
        else
            return "fail";
    }

    @RequestMapping("/registercheck")
    @ResponseBody
    public Map<String,String > registercheck(@RequestBody User user){
        Map<String,String> map=new HashMap<>();
        String code="2000";
        if(user.getUserName()==null||user.getUserName().equals("")){
            code="500";
        }else{
            List<User> users=userService.selectAll();
            for (User u:users) {
                if(u.getUserName().equals(user.getUserName())){
                    code="400";
                    break;
                }
            }
        }
        map.put("code",code);
        return map;
    }


    @RequestMapping("/userinfo")
    @ResponseBody
    public PageInfo<User> userInfo(String page){
        int pn=Integer.parseInt(page);
        PageHelper.startPage(pn,5);
        List<User> userList=userService.selectAll();
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        System.out.println(pn);
        return pageInfo;
    }


    @RequestMapping("/upduser")
    public String updUser(@RequestParam("userId") Integer userId,Model model){
        User user=userService.selectByuserId(userId);
        model.addAttribute("user",user);
        return "updauser";
    }

    @RequestMapping("/test")
    @ResponseBody
    public User test(@RequestParam("userId") Integer userId,Model model){
        User user=userService.selectByuserId(userId);
        System.out.println(user.getLastLoginTime());
        System.out.println(user.getRegTime());
        model.addAttribute("user",user);
        return user;
    }

    @RequestMapping("/update")
    @ResponseBody
    public User update(User user,String uId){
        User u;
        if(uId!=null){
            u=userService.selectByuserId(Integer.parseInt(uId));
            System.out.println(uId+"#####################");
        }else{
            userService.updateUser(user);
            u=userService.selectByuserId(user.getUserId());
            System.out.println(user+"#####################");
        }
        return u;
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("userId") Integer userId,Model model){
        boolean isDelete =userService.deleteUserByUserId(userId);
        if(isDelete){
            PageHelper.startPage(1,5);
            List<User> userList=userService.selectAll();
            PageInfo<User> userpageInfo= new PageInfo<>(userList);
            model.addAttribute("userpageInfo",userpageInfo);
        }
        return "usermanager";
    }
}
