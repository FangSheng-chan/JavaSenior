package collectionTool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fangsheng
 * @date 2021/7/14 2:44 下午
 */
public class ListDuple {

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("1");
    strings.add("2");
    strings.add("2");
    strings.add("1");
    List<String> strings1 = removeStringListDuple(strings);
    System.out.println(strings1);
  }

  public static List<String> removeStringListDuple(List<String> stringList) {
    Set<String> set = new HashSet<>();
    set.addAll(stringList);
    stringList.clear();
    stringList.addAll(set);
    return stringList;
  }
}
