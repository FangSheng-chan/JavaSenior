package t11;

/**
 * @author fangsheng
 * @date 2021/2/26 上午11:30
 */
public class test1 {
    public static void main(String[] args) {
        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));
    }
}
