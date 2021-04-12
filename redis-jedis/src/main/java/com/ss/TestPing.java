package com.ss;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author fangsheng
 * @date 2021/3/29 下午9:08
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        System.out.println("判断某个key是否存在：" + jedis.exists("username"));
        System.out.println("新增键值" + jedis.set("username", "ss"));
        System.out.println("新增" + jedis.set("password", "Hello.001"));
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        String username = jedis.get("username");
        System.out.println(username);
        jedis.rename("username","ssName");
        System.out.println(jedis.get("ssName"));
        System.out.println(jedis.dbSize());
        String ssName = jedis.type("ssName");
        System.out.println(ssName);
        System.out.println(jedis.select(1));
        System.out.println(jedis.dbSize());
    }
}
