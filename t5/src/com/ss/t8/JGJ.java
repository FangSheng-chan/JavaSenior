package com.ss.t8;

public class JGJ extends Wine{
    public JGJ(){
        setName("JGJ");
    }

    /**
     * 重写父类方法，实现多态
     */
    @Override
    public String drink(){
        return "喝的是 " + getName();
    }

    /**
     * 重写toString()
     */
    @Override
    public String toString(){
        return "Wine : " + getName();
    }
}
