package 回溯算法DFS算法;


import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/3/31 上午10:53
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res_2 = new ArrayList<>();

        res.add(list);
        res_2.add(new ArrayList<>(list));
        System.out.println("res为：");
        System.out.println(res);
        System.out.println("res_2为：");
        System.out.println(res_2);

        list.add(4);
        res.add(list);
        res_2.add(new ArrayList<>(list));
        System.out.println("res为：");
        System.out.println(res);
        System.out.println("res_2为：");
        System.out.println(res_2);

        test3();
        test4();
    }


    public static void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> result = new ArrayList<>();
        System.out.println(result);
        result.add(list);
        System.out.println(result);
        list.add(4);
        result.add(list);
        System.out.println(result);
    }

    public static void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> result = new ArrayList<>();
        System.out.println(result);
        result.add(new ArrayList<>(list));
        System.out.println(result);
        list.add(4);
        result.add(new ArrayList<>(list));
        System.out.println(result);
    }

    public static void test3() {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            row.add(i);
            res.add(row);
        }
        System.out.println(res);
    }

    public static void test4() {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            row.add(i);
            res.add(new ArrayList<>(row));
        }
        System.out.println(res);
    }
}
