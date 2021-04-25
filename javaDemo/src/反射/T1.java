package 反射;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author fangsheng
 * @date 2021/4/21 下午2:01
 */
public class T1 {
    public static void main(String[] args) throws Exception {
        Class<Student> studentClass = Student.class;
        Constructor<Student> constructor = studentClass.getConstructor(String.class);
        Student student = constructor.newInstance("tom");
        System.out.println(student.toString());
        // 根据CLass对象获取Method时，需要传入方法名+参数的Class类型
        Method show = studentClass.getMethod("show");
        show.invoke(student);
    }


    @Test
    public void t1() {
        try {
            Class<?> clz = Class.forName("反射.Student");
            Object o = clz.newInstance();
            Method m = clz.getDeclaredMethod("show", String.class, int.class);
            m.setAccessible(Boolean.TRUE);
            m.invoke(o, "ss", 22);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    public void t2() {
        try {
            Class<?> empClass = Class.forName("反射.Emp");
            System.out.println("获取到一个Emp对象");
            Emp emp = (Emp) empClass.newInstance();
            System.out.println();

//            Method method1 = empClass.getMethod("public_print",null);
//            method1.invoke(emp,null);
//
//            Method method2 = empClass.getMethod("public_show", String.class, int.class);
//            method2.invoke(emp,"ss",22);
//
//            Method method3 = empClass.getDeclaredMethod("private_show", String.class, int.class);
//            method3.setAccessible(Boolean.TRUE);
//            method3.invoke(emp,"dd",21);

            Method method4 = empClass.getMethod("getAge", int.class);
            Object invoke = method4.invoke(emp, 21);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t3() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Emp.class);
        for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
            System.out.println(propertyDescriptor.getName());
            System.out.println(propertyDescriptor.getReadMethod());
        }
    }
}
