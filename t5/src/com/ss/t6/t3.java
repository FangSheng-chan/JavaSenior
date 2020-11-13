package com.ss.t6;

import java.util.ArrayList;

public class t3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        f5(67);
    }

    // return在无返回值方法的特殊使用
    public static void f5(int a) {
        if (a > 10) {
            return;//表示结束所在方法 （f5方法）的执行,下方的输出语句不会执行
        }
        System.out.println(a);
    }
}
