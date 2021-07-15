package 迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/7/13 4:45 下午
 */
public class ConcreteAggregate {

  private List list = new ArrayList();

  public void add(Object obj) {
    list.add(obj);
  }

  public MyIterator iterator() {
    return new ConcreteIterator(list);
  }

  public void remove(Object obj) {
    list.remove(obj);
  }
}
