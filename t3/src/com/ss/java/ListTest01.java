package com.ss.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        System.out.println(dataList());
        System.out.println(dataList2());

        List<Object> list1 = dataList();

        List<List<Object>> list2 = dataList2();


        Object o = list1.get(1);
        List<Object> objectList = list2.get(1);

        for (Object o1 : list1) {

        }
        for (List<Object> objects : list2) {

        }

        System.out.println(o);
        System.out.println(objectList);

    }


    private static List<Object> dataList() {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<Object>();
            data.add("字符串" + i);
            data.add(new Date());
            data.add(0.56);
            list.add(data);
        }
        return list;
    }


    private static List<List<Object>> dataList2() {
        List<List<Object>> list = new ArrayList<List<Object>>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<Object>();
            data.add("字符串" + i);
            data.add(new Date());
            data.add(0.56);
            list.add(data);
        }
        return list;
    }

}
