package com.ss;

import redis.clients.jedis.Jedis;

/**
 * @author fangsheng
 * @date 2021/3/29 下午9:08
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }
}
