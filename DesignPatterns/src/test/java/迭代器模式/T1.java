package 迭代器模式;

import org.junit.Test;

import java.util.*;

/**
 * @author fangsheng
 * @date 2021/7/9 2:08 下午
 */
public class T1 {
  @Test
  public void t1() {
    Map<Object, Object> map = new HashMap<>();
    map.put(1, 1);
    map.put(2, 2);
    map.put(3, 3);

    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    print(list);
  }

  @Test
  public void t2() {
    ConcreteAggregate concreteAggregate = new ConcreteAggregate();
    concreteAggregate.add("小明");
    concreteAggregate.add("小红");
    MyIterator iterator = concreteAggregate.iterator();
    while (iterator.hasNext()) {
      Object next = iterator.next();
      System.out.println(next);
    }
  }

  private static void print(Collection collection) {
    Iterator iterator = collection.iterator();
    while (iterator.hasNext()) {
      Object str = iterator.next();
      System.out.println(str);
    }
  }
}
