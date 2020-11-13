package com.ss.t8;

/**
 * 子类构造器，继承SuperClass
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("子类的静态代码块，程序启动后执行，只会执行一次，先执行父类的，再执行子类的");
    }

    {
        System.out.println("子类构造代码块，每次调用构造方法都会执行的");
    }

    /**
     * 无参构造器
     */
    public SubClass(){

        //这里没有指定调用父类哪个构造器，会默认调用 super()，调用父类的无参构造器public SuperClass()
    }

    /**
     * 重载构造器，多传两个参数
     * @param str
     * @param str1
     */
    public SubClass(String str,String str1){
        //必须写在构造器第一行，调用父类构造器 public SuperClass(String str)
        super(str,str1);
        System.out.println("子类带参构造器：" + str1);
    }
}
