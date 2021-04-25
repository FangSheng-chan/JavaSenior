package 反射;

/**
 * @author fangsheng
 * @date 2021/4/22 上午11:19
 */
public class Emp {
    private Integer age;
    private String name;

    public Emp() {
    }

    public Emp(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public void public_show(String str, int i) {
        System.out.println("public show " + str + "..." + i);
    }

    public void public_print() {
        System.out.println("public print");
    }

    private void private_show(String s, int i) {
        System.out.println("public print " + s + "..." + i);
    }

    private void private_print() {
        System.out.println("private print");
    }

    public int getAge(int age){
        return age;
    }
}
