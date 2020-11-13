package t2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) {
        CarCompetion carCompetion = new CarCompetion();
        final ExecutorService carPool =
                Executors.newFixedThreadPool(carCompetion.totalCarNum);
        for (int i = 0; i < carCompetion.totalCarNum; i++) {
            carPool.execute(new Car(i, carCompetion));
        }
    }
}
