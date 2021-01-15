package t2;

public class t6 {
    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 2;
        a[1] = 4;
        a[2] = 6;
        System.arraycopy(a,2,a,1,8);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
