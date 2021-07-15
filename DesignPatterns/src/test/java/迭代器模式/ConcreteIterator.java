package 迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/7/13 4:32 下午
 */
public class ConcreteIterator implements MyIterator {

  private List list = new ArrayList();

  private int cursor = 0;

  public ConcreteIterator(List list) {
    this.list = list;
  }

  @Override
  public Object next() {
    Object object = null;
    if (this.hasNext()) {
      object = this.list.get(cursor++);
    }
    return object;
  }

  @Override
  public boolean hasNext() {
    if (cursor == list.size()) {
      return false;
    }
    return true;
  }
}
