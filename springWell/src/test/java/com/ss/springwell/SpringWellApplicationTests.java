package com.ss.springwell;

import com.ss.springwell.config.Sysconfig;
import com.ss.springwell.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootTest
class SpringWellApplicationTests {

    @Resource
    private Sysconfig sysconfig;

    @Test
    void contextLoads() {
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);

    }

    @Test
    void t1() {

    }


}
