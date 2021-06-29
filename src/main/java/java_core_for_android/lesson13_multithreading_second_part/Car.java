package java_core_for_android.lesson13_multithreading_second_part;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static final CyclicBarrier prepareBarrier = new CyclicBarrier(MainRace.CARS_COUNT);
    private static boolean isSomeoneWin = false;
    private static Lock locker = new ReentrantLock();

    private Race race;
    private int speed;
    private String name;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            prepareBarrier.await();
            System.out.println(this.name + " готов");
            MainRace.cdlCountDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        printFinish();
        MainRace.cdlCountDown();
    }

    private void printFinish() {
        locker.lock();
        if (!isSomeoneWin) {
            System.out.println(name + " - Win!!!");
            isSomeoneWin = true;
        }
        locker.unlock();
    }
}
