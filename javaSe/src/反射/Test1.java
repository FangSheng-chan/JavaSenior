package 反射;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author fangsheng
 * @date 2021/3/12 下午3:22
 */
public class Test1 {

    public String name = "ss";

    @Test
    public void test1() {
        User user = new User();
        System.out.println(user instanceof Person);

    }

    /**
     * 反射的动态性
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> Classname = Class.forName("反射.Test1");
        try {
            Test1 ss = (Test1) Classname.newInstance();
            System.out.println(ss.name);
            ss.test1();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class类的理解
     * 1、Class实例对应加载到内存中一个运行时类
     */
    @Test
    public void test3() {
        try {
            Class<?> aClass = Class.forName("反射.User");
            try {
                Method show = aClass.getDeclaredMethod("show");
                String defaultValue = show.getName();
                System.out.println(defaultValue);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Object instance = getInstance("反射.User");
        System.out.println(instance);
    }

    public  Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
