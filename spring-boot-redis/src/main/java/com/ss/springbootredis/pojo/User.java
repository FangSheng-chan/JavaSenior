package com.ss.springbootredis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author fangsheng
 * @date 2021/3/30 下午7:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class User {
    private String Name;
    private Integer age;
}
