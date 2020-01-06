package com.clt.controller;

import com.clt.email.MailUtil;
import com.clt.mapper.ProductMapper;
import com.clt.pojo.Email;
import com.clt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("/check")
    @ResponseBody
    public Map<String ,String > loginCheck(@RequestBody  User user){
        Jedis jedis=null;
        Map<String ,String> map=new HashMap<>();
        String code=null;
        try {
            jedis=new Jedis("192.168.56.101",6379);
            String temp;
            String password=jedis.hget(user.getUserName(),"password");
            if(password!=null){
                temp=jedis.hget(user.getUserName(),"count");
                if(Integer.parseInt(temp)>=2){
                    map.put("code","400");
                    jedis.del(user.getUserName());
                }else if(user.getPassWord().equals(password)){
                    jedis.set(user.getUserName()+"check","0");
                    map.put("code","100");
                }else {
                    jedis.hincrBy(user.getUserName(),"count",1);
                    map.put("code","200");
                }
            }else {
                map.put("code","404");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return map;
    }

    @RequestMapping("/send")
    @ResponseBody
    public Map<String ,String > send(@RequestBody User user,HttpSession session){
        Jedis jedis=null;
        Random random=new Random();
        Map<String ,String > rmap=new HashMap<>();
        Map<String ,String > map=new HashMap<>();
        String inPath="F:/mytest/ssm1/src/main/webapp/images/pw";
        Date date=new Date();
        try{
            jedis=new Jedis("192.168.56.101",6379);
            String content="";
            long retime=(24-date.getHours())*3600-(date.getMinutes()*60)-(date.getSeconds());
            inPath+=retime;
            inPath+=".jpg";
            for (int i=0;i<6;i++){
                int temp=random.nextInt(10);
                content+=temp;
            }
            String key=user.getUserName()+"check";
            String check=jedis.get(key);
            if(check!=null){
               if(Integer.parseInt(check)>=3){
                   jedis.expire(key,(int) retime);
                   map.put("check","200");
                   return map;
               }else {
                   jedis.incr(key);
               }
            }else{
                jedis.set(key,"1");
            }
            rmap.put("password",content);
            rmap.put("count","0");
            jedis.hmset(user.getUserName(),rmap);
            jedis.expire(user.getUserName(),60);
            MailUtil mailUtil = new MailUtil();
            mailUtil.sendSimpleMail(new Email(user.getUserName(),"验证码邮件",content));
            map.put("code","500");
            map.put("src","/images/pw"+retime+".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return map;
    }


}
