package com.ss.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author fangsheng
 * @date 2021/5/21 10:46 上午
 */
@Slf4j
@Component
public class CustomerService {
    /**
     * 添加收获地址
     */
    public void addCustomer(Long customerId, String userName, String address) {
        log.info("调用成功addCustomer,当前请求参数customerId={},userName={},address={}", customerId, userName, address);
    }
}
