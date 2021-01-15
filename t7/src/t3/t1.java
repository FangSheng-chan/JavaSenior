package t3;


import java.util.ArrayList;
import java.util.LinkedList;

public class t1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(66);
        LinkedList<Object> objects = new LinkedList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(5);
        objects.add(7);
        int i = objects.indexOf(9);
        System.out.println(i);


        objects.addAll(arrayList);


        ssLinkedList<Integer> list = new ssLinkedList<>();
        list.add(1);
        list.add(2);
        list.addFirst(111);
        list.add(3);
        list.add(5);
        list.add(6);
        list.addAll(arrayList);
        System.out.println(list.get(6));
    }
}
