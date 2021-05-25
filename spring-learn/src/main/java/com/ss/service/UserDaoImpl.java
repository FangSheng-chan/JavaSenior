package com.ss.service;

/**
 * @author fangsheng
 * @date 2021/5/20 4:01 下午
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
