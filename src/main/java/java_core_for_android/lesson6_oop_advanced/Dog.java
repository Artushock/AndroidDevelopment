package java_core_for_android.lesson6_oop_advanced;
/*
    @author Artiom Ponomariov
*/

public class Dog extends Animal{
    protected static int amountOfDogs = 0;
    private final int DOG_RUN_DISTANCE_LIMIT = 500;
    private final int DOG_SWIM_DISTANCE_LIMIT = 10;

    public Dog(String name) {
        super(name);
        super.setRunDistanceLimit(DOG_RUN_DISTANCE_LIMIT);
        super.setSwimDistanceLimit(DOG_SWIM_DISTANCE_LIMIT);
        amountOfDogs++;
    }

    @Override
    public void voice() {
        System.out.println("Гав!");
    }
}
