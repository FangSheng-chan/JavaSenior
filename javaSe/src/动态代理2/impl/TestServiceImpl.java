package 动态代理2.impl;

import 动态代理2.TestService;

/**
 * @author fangsheng
 * @date 2021/7/9 10:41 下午
 */
public class TestServiceImpl implements TestService {

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
