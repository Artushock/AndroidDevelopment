package java_core_for_android.lesson6_oop_advanced;
/*
    @author Artiom Ponomariov
*/

public abstract class Animal {
    protected static int amountOfAnimals = 0;

    private String name;
    private int runDistanceLimit;
    private int swimDistanceLimit;

    public Animal(String name) {
        this.name = name;
        amountOfAnimals++;
    }
    public void run(int distance){
        if(runDistanceLimit == 0) {
            System.out.printf("%s не умеет бегать.%n", name);
            return;
        }

        if (distance < runDistanceLimit){
            System.out.printf("%s пробежал %d м.%n", name, distance);
        } else {
            System.out.printf("%s не смог пробежать %d м.%n", name, distance);
        }
    }

    public void swim(int distance){
        if(swimDistanceLimit == 0) {
            System.out.printf("%s не умеет плавать.%n", name);
            return;
        }

        if (distance < swimDistanceLimit){
            System.out.printf("%s проплыл %d м.%n", name, distance);
        } else {
            System.out.printf("%s не смог проплыть %d м.%n", name, distance);
        }
    }

    public void setRunDistanceLimit(int runDistanceLimit) {
        this.runDistanceLimit = runDistanceLimit;
    }

    public void setSwimDistanceLimit(int swimDistanceLimit) {
        this.swimDistanceLimit = swimDistanceLimit;
    }

    public abstract void voice();
}
