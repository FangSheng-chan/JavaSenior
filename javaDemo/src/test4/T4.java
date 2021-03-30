package test4;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fangsheng
 * @date 2021/3/17 下午4:32
 */
public class T4 {
    public static void main(String[] args) {
        String[] arr = {"aa", "bb", "cc"};
        String collect = Arrays.stream(arr).collect(Collectors.joining("|"));
        System.out.println(collect);

        List<String> list = Arrays.stream(arr).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list);
    }

    @Test
    public void test1() {
        List<User> users = new ArrayList<>();
        users.add(new User("ss1", "1", 16));
        users.add(new User("ss2", "2", 17));
        users.add(new User("ss3", "", 18));
        users.add(new User("ass4", "", 18));
        users.add(new User("bss5", "", 18));

        List<User> userList = users.stream().filter(user -> user.getAge() > 17).sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
        for (User user : userList) {
            System.out.println(user);
        }

        System.out.println("------");
//        Collections.singletonMap()
//        users.stream().collect(Collectors.groupingBy())
    }
}
