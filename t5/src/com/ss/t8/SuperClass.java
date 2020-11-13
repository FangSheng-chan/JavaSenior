package com.ss.t8;

/**
 * 父类构造器
 */
public class SuperClass {

    {
        System.out.println("父类构造代码块，每次调用构造方法都会执行的");
    }

    /**
     * 父类无参构造方法
     */
    public SuperClass() {
        System.out.println("父类的默认构造方法");
    }

    /**
     * 重载，自定义父类带参构造方法
     *
     * @param str
     */
    public SuperClass(String str) {
        System.out.println("父类的带参构造方法，参数为：" + str);
    }

    public SuperClass(String str1, String str2) {
        System.out.println("str1:" + str1 + "\t\tstr2:" + str2);
    }

    static {
        System.out.println("父类的静态代码块，程序启动后执行，只会执行一次");
    }

}
