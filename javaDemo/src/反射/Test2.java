package 反射;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Random;

/**
 * @author fangsheng
 * @date 2021/3/18 下午3:03
 */
public class Test2 {
    public static void main(String[] args) {
        Student student = new Student("ss", 22);
        student.age = 18;
        System.out.println(student.toString());
        student.show();
    }

    @Test
    public void test01() throws Exception {
        Class<Student> personClass = Student.class;
        //通过反射，创建Student类的对象
        Constructor<Student> constructor = personClass.getConstructor(String.class, Integer.class);
        Student p = constructor.newInstance("tom", 12);
        System.out.println(p.toString());
        // 调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());
        // 调用方法
        Student student = new Student("ss",22);
        Method showMethod = personClass.getMethod("showCoolBoy", String.class, int.class);
        showMethod.invoke(student);
    }

    @Test
    public void test02() throws Exception {
        Class<Student> studentClass = Student.class;

        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Student student = declaredConstructor.newInstance("kala");
        System.out.println(student);

        Field name = studentClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(student, "Taoyao");
        System.out.println(student);
    }

    @Test
    public void test03() throws Exception {
        Class<?> aClass = Class.forName("反射.Student");
        Student o = (Student) aClass.newInstance();
        System.out.println(o);
//        Method[] methods = aClass.getMethods();
//        for (Method method : methods) {
//            Class<?> declaringClass = method.getDeclaringClass();
//            System.out.println(declaringClass);
//        }
    }

    @Test
    public void test04() throws ClassNotFoundException {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "反射.Student";
                    break;
            }
            Object instance = getInstance(classPath);
            System.out.println(instance);
        }
    }

    public Object getInstance(String classPath) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(classPath);
        return aClass;
    }

    @Test
    public void test5() {
        Class<Student> studentClass = Student.class;
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("===========");

        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    @Test
    public void test06() {
        Class<Student> studentClass = Student.class;
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            int modifiers = declaredField.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            Class<?> type = declaredField.getType();
            System.out.println(type.getName());
            String name = declaredField.getName();
            System.out.println(name);
            System.out.println("===========");
        }
    }

    @Test
    public void test07() {
        Class<Student> studentClass = Student.class;
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println(method + "***");
        }

        System.out.println("==========");

        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    @Test
    public void test8() throws Exception {
        Class<Student> studentClass = Student.class;

        Student student = studentClass.newInstance();

        Field name = studentClass.getDeclaredField("name");

        Method showCoolBoy = studentClass.getDeclaredMethod("showCoolBoy", String.class, int.class);

        showCoolBoy.setAccessible(true);

        Object invoke = showCoolBoy.invoke(student, "fangsheng", 17);

        System.out.println(invoke);
    }
}















