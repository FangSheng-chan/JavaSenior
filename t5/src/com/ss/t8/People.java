package com.ss.t8;

public class People {

    static {
        System.out.println("静态代码块，程序启动后执行，只会执行一次");
    }

    /**
     * 默认的无参构造器
     */
    public People(){
        System.out.println("默认构造器");
    }

    /**
     * 构造器重载，自定义一个带参构造器
     * @param str
     */
    public People(String str){
        System.out.println("带参构造器，参数：" + str);
    }

    {
        System.out.println("构造代码块，每次调用构造方法都会执行一次");
    }
}
