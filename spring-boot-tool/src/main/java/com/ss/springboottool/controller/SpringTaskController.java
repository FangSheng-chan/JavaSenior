package com.ss.springboottool.controller;

import com.ss.springboottool.service.SpringTaskTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fangsheng
 * @date 2021/5/20 10:02 上午
 */
@RestController
public class SpringTaskController {

    @Resource
    private SpringTaskTest springTaskTest;

//    @GetMapping("/springTask")
//    public void springTask(){
//        springTaskTest.run();
//    }

}
