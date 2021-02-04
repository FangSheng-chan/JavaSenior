package com.ss.t8.config;

import com.ss.t8.model.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/1/25 4:28 下午
 */
@ControllerAdvice
@ResponseBody
public class GlobeControllerAdvice {

    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setName("fang");
        user.setAge("21");
        return user;
    }

    @ExceptionHandler(CommonException.class)
    public Map<String, Object> customException(final CommonException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", e.getStatus());
        result.put("message", e.getMessage());
        return result;
    }

}
