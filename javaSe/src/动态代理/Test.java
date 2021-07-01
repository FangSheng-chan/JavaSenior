package 动态代理;


/**
 * @author fangsheng
 * @date 2021/3/19 下午2:22
 */
public class Test {
    public static void main(String[] args) {
        Hello instance = (Hello) MyProxyFactory.getInstance(Hello.class);
        instance.morning("ss");
    }
}

interface Hello {
    void morning(String name);
}
