package t6;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException, InvocationTargetException {

        TargetObject object = new TargetObject();
        Class<? extends TargetObject> objectClass = object.getClass();
        TargetObject targetObject = objectClass.newInstance();

        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method publicMethod = objectClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(object, "\tfangsheng");

        Field field = objectClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(field,"ss");

    }
}
