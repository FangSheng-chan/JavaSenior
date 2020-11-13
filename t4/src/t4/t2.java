package t4;

public class t2 {
    public static void main(String[] args) {
        Account account = new Account();
        Thread thread = new Thread(new AddMoneyThread(account, 1));
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);
        Thread t4 = new Thread(thread);
        Thread t5 = new Thread(thread);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        System.out.println(account.getBalance());
    }
}
