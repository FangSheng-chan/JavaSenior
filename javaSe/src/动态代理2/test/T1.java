package 动态代理2.test;

import 动态代理2.impl.TestServiceImpl;

/**
 * @author fangsheng
 * @date 2021/7/9 10:42 下午
 */
public class T1 {
    public static void main(String[] args) {
        TestServiceImpl testService = new TestServiceImpl();
        testService.sayHello();
    }
}
