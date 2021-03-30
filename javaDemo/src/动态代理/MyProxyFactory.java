package 动态代理;

import java.lang.reflect.Proxy;

/**
 * @author fangsheng
 * @date 2021/3/19 下午2:34
 */
public class MyProxyFactory {
    public static Object getInstance(Class mapperInterface) {
        MyProxy myProxy = new MyProxy();
        return Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, myProxy);
    }
}
