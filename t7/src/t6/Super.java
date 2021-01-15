package t6;

public class Super {
    protected int number;

    protected void showNumber() {
        System.out.println("number" + number);
    }
}

class Sub extends Super {
    void bar() {
        int s = 0;
        super.number = 10;
        super.showNumber();
    }
}
