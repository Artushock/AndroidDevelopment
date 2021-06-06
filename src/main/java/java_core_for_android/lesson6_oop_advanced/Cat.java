package java_core_for_android.lesson6_oop_advanced;
/*
    @author Artiom Ponomariov
*/

public class Cat extends Animal {
    protected static int amountOfCats = 0;
    private final int DEFAULT_CAT_RUN_DISTANCE_LIMIT = 200;
    private final int DEFAULT_CAT_SWIM_DISTANCE_LIMIT = 0;

    public Cat(String name) {
        super(name);
        super.setRunDistanceLimit(DEFAULT_CAT_RUN_DISTANCE_LIMIT);
        super.setSwimDistanceLimit(DEFAULT_CAT_SWIM_DISTANCE_LIMIT);
        amountOfCats++;
    }

    public Cat(String name, int runDistanceLimit, int swimDistanceLimit) {
        super(name, runDistanceLimit, swimDistanceLimit);
        amountOfCats++;
    }

    @Override
    public void voice() {
        System.out.println("Мяу!");
    }
}
