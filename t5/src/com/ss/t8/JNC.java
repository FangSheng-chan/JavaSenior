package com.ss.t8;

public class JNC extends Wine{

    public JNC(){
        setName("JNC");
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

