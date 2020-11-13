package t7;


public class Account {
    private double balance;

    public void deposit(double money){
        double newBalance = balance + money;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }
}
