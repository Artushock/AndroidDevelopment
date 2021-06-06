package java_core_for_android.lesson6_oop_advanced;
/*
    @author Artiom Ponomariov
*/

public class Dog extends Animal{
    protected static int amountOfDogs = 0;
    private final int DEFAULT_DOG_RUN_DISTANCE_LIMIT = 500;
    private final int DEFAULT_DOG_SWIM_DISTANCE_LIMIT = 10;

    public Dog(String name) {
        super(name);
        super.setRunDistanceLimit(DEFAULT_DOG_RUN_DISTANCE_LIMIT);
        super.setSwimDistanceLimit(DEFAULT_DOG_SWIM_DISTANCE_LIMIT);
        amountOfDogs++;
    }

    public Dog(String name, int dogRunDistanceLimit, int dogSwimDistanceLimit) {
        super(name, dogRunDistanceLimit, dogSwimDistanceLimit);
        amountOfDogs++;
    }

    @Override
    public void voice() {
        System.out.println("Гав!");
    }
}
