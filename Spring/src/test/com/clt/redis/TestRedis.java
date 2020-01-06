package com.clt.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.56.101",6379);
        System.out.println(jedis.ping());
        jedis.set("k1","v1");
        jedis.mset("k2","v2","k3","v3");
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.mget("k1","k2","k3"));
        jedis.hset("h1","username","chen");
        System.out.println(jedis.hget("h1","username"));
        Map<String ,String > map=new HashMap<>();
        map.put("tel","15151515");
        map.put("email","dssa@qq.com");
        jedis.hmset("h2",map);
        List<String> list=jedis.hmget("h2","tel","email");
        for (String s:list
             ) {
            System.out.println(s);
        }

    }
}
