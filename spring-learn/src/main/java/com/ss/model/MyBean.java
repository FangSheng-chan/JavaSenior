package com.ss.model;

import com.ss.model.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author fangsheng
 * @date 2021/5/20 2:43 下午
 */
public class MyBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setUserName("王五");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
