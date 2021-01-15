package t5;

import java.util.Date;

public  class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }

    @Override
    public  void run() {
        System.out.println(Thread.currentThread().getName() + " start . Time =" + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " end Time +" + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
