package com.ss;

import redis.clients.jedis.Jedis;

/**
 * @author fangsheng
 * @date 2021/3/30 下午6:39
 */
public class TestList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        jedis.lpush("collections", "ArrayList", "Stack", "HashMap", "Stack", "HashMap", "Stack", "Stack");
        jedis.lpush("collections", "ss", "dd");
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.lrange("collections", 0, 2));
        System.out.println(jedis.lrem("collections", 2, "Stack"));
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.lpop("collections"));
        System.out.println(jedis.rpop("collections"));
        jedis.lset("collections",1,"zzzzz");
        System.out.println(jedis.lrange("collections", 0, -1));
        System.out.println(jedis.lindex("collections",2));
        jedis.lpush("number", "1", "3", "2", "6");
        System.out.println(jedis.sort("number"));
        System.out.println(jedis.lrange("number", 0, -1));
    }
}
