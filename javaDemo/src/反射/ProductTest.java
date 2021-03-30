package 反射;

/**
 * @author fangsheng
 * @date 2021/3/18 下午6:22
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 */
interface Moon {
    String getBelief();

    void Object(String Moon);
}

class Venus implements Moon {

    @Override
    public String getBelief() {
        return "他和她住在同一颗星球🌍";
    }

    @Override
    public void Object(String Moon) {
        System.out.println("surround by\t" + Moon);
    }
}

class DeskProxyFactory {
    /**
     * 调用此方法，返回一个代理类的对象，解决问题一：
     * obj：被代理的对象
     *
     * @param obj
     * @return
     */
    public static Object getProxyInstance(Object obj) {
        DeskProxy hander = new DeskProxy();
        hander.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), hander);
    }
}

class DeskProxy implements InvocationHandler {

    private Object object;

    public void bind(Object object) {
        this.object = object;
    }

    /**
     * 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
     * 将被代理类要执行的方法a的功能就声明在invoke
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(object, args);
        return returnValue;
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Venus venus = new Venus();
        Moon proxyInstance = (Moon) DeskProxyFactory.getProxyInstance(venus);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
    }
}
