package com.ss.t8.controller;

import com.ss.t8.config.CommonException;
import com.ss.t8.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/1/25 4:32 下午
 */
@RestController
public class UserController {
    @GetMapping("/index")
    public Map<String, String> index(@ModelAttribute("user") User user) {
        HashMap<String, String> result = new HashMap<>();
        result.put("name", user.getName());
        result.put("age", user.getAge());
        return result;
    }

    @GetMapping("/fsException")
    public Map<String, Object> exception() {
        if (true) {
            throw new CommonException("555", "方胜代码抛出异常");
        }
        return new HashMap<>();
    }


}
