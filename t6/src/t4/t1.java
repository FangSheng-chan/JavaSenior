package t4;

public class t1 {
    public static void main(String[] args) {
        person ss = new person("ss", 1);
        person ss2 = new person("ss", 1);
        System.out.println(ss.hashCode());
        System.out.println(ss2.hashCode());
        System.out.println(ss.equals(ss2));
    }
}
