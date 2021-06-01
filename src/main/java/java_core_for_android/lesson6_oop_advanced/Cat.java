package java_core_for_android.lesson6_oop_advanced;
/*
    @author Artiom Ponomariov
*/

public class Cat extends Animal {
    protected static int amountOfCats = 0;
    private final int CAT_RUN_DISTANCE_LIMIT = 200;
    private final int CAT_SWIM_DISTANCE_LIMIT = 0;

    public Cat(String name) {
        super(name);
        super.setRunDistanceLimit(CAT_RUN_DISTANCE_LIMIT);
        super.setSwimDistanceLimit(CAT_SWIM_DISTANCE_LIMIT);
        amountOfCats++;
    }

    @Override
    public void voice() {
        System.out.println("Мяу!");
    }
}
