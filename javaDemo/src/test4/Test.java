package test4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fangsheng
 * @date 2021/3/9 下午7:40
 */
public class Test {

    static interface Subject {
        void sayHi();

        void sayHello();
    }

    static class SubjectImpl implements Subject {

        @Override
        public void sayHi() {
            System.out.println("hi");
        }

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class ProxyInvocationHandler implements InvocationHandler {

        private Subject subject;

        public ProxyInvocationHandler(Subject subject) {
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("say:");
            return method.invoke(subject, args);
        }
    }

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(subject.getClass()
                .getClassLoader(), subject.getClass().getInterfaces(), new ProxyInvocationHandler(subject));
        subjectProxy.sayHi();

    }
}
