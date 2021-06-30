package java_core_for_android.lesson13_multithreading_second_part;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/*@author Artiom Ponomariov*/
public class MainRace {
    public static final int CARS_COUNT = 4;
    private static CountDownLatch waitForFinish = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatch, cyclicBarrier);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        countDownLatch.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        waitForFinish.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public static void waitForFinishCountDown(){
        waitForFinish.countDown();
    }
}

