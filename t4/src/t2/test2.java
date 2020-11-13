package t2;

public class test2 {
    public static void main(String[] args) {
        CarCompetion carCompetion = new CarCompetion();
        for (int i = 0; i < carCompetion.totalCarNum; i++) {
            Car car = new Car(i, carCompetion);
            Thread t = new Thread(car);
            t.start();
        }
    }
}
