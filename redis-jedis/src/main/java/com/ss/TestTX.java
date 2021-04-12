package com.ss;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author fangsheng
 * @date 2021/3/30 下午6:56
 */
public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "ss");
        jsonObject.put("name", "dd");
        String result = jsonObject.toString();
        //开启事务
        Transaction multi = jedis.multi();
        try {
            multi.set("user1", result);
            multi.set("user2", result);
            int i = 1 / 0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
