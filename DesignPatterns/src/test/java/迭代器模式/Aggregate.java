package 迭代器模式;

/**
 * @author fangsheng
 * @date 2021/7/13 4:44 下午
 */
public interface Aggregate {

  public void add(Object o);

  public void remove(Object o);

  public MyIterator MyIterator();
}
