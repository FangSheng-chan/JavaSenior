package test5;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * @author fangsheng
 * @date 2021/4/21 下午6:37
 */
public class T5 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < 1000; i++) {
//            stringBuilder.append(",");
//            stringBuilder.append(i);
//        }
//        System.out.println(stringBuilder.toString());
        stringBuilder.append("Mr").append("Bob").append("!").insert(0, "Hello , ");
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void t1() {
        Adder adder = new Adder();
        Adder add = adder.add(2).inc().add(9);
        System.out.println(add.value());
    }

    @Test
    public void t2() {
        String[] names = {"Bob", "Alice", "Grace"};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        for (String name : names) {
            stringBuilder.append(name).append(",");
        }
        System.out.println(stringBuilder.toString());
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("!");
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void t3() {
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner stringJoiner = new StringJoiner(",");
        StringJoiner sj = new StringJoiner(",", "Hello ", "!");
        for (String name : names) {
            stringJoiner.add(name);
        }
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(stringJoiner.toString());
        System.out.println(sj.toString());
    }

    @Test
    public void t4() {
        String[] names = {"Bob", "Alice", "Grace"};
        String join = String.join(",", names);
        System.out.println(join);
        Queue q = new LinkedList();
        Stack s = new Stack();
        System.out.println(Boolean.TRUE);
    }

    @Test
    public void t5() {
        System.out.println(Boolean.TRUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.BYTES);
        System.out.println(Long.SIZE);
        System.out.println(Integer.BYTES);
    }

    @Test
    public void t6() {
        // 向上转型为Number:
        Number num = new Integer(127);
        // 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int n = num.intValue();
        long ln = num.longValue();
        float f = num.floatValue();
        double d = num.doubleValue();
        System.out.println(b);
        System.out.println(n);
        System.out.println(ln);
        System.out.println(f);
        System.out.println(d);
    }

    @Test
    public void t7() {
        Week day = Week.SUN;

        if (day == Week.SAT || day == Week.SUN) {
            System.out.println("work at home");
        } else {
            System.out.println("work at office");
        }
    }

    @Test
    public void t8() {
        Week day = Week.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("at home");
            System.out.println(day.toString());
        } else {
            System.out.println("at office");
        }
    }

    @Test
    public void t9() {
        Week day = Week.WED;
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THE:
            case FRI:
                System.out.println(day.name() + " at office");
                break;
            case SAT:
            case SUN:
                System.out.println(day.name() + " at home");
                break;
            default:
                throw new RuntimeException("cannot process" + day);
        }
    }
}
