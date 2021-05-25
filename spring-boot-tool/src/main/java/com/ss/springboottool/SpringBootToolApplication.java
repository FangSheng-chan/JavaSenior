package com.ss.springboottool;


import com.ss.springboottool.aop.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootToolApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootToolApplication.class, args);
        CustomerService customerService = (CustomerService) context.getBean(CustomerService.class);
        customerService.addCustomer(1L, "ss", "杭州");
        customerService.addCustomer(1L, "dd", "杭州");
    }
}
