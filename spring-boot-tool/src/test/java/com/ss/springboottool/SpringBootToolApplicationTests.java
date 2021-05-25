package com.ss.springboottool;

import com.ss.springboottool.service.SpringTaskTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootToolApplicationTests {

    @Resource
    private SpringTaskTest springTaskTest;

    @Test
    void contextLoads() {
//        springTaskTest.run();
    }

}
