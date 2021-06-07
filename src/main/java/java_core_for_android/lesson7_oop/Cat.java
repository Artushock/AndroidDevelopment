package java_core_for_android.lesson7_oop;
/*
    @author Artiom Ponomariov
*/

import java.util.Random;

public class Cat {
    private final String name;
    private final Random random = new Random();
    private boolean satiety = false;
    private int actualAppetite;
    private int maxAppetite;

    public Cat(String name) {
        this.name = name;
    }

    public boolean eat(Plate plate) {
        maxAppetite = random.nextInt(4) + 3;
        actualAppetite = plate.decreaseFood(maxAppetite);
        return satiety = maxAppetite == actualAppetite;
    }

    public void satietyInfo(){
        if (satiety){
            System.out.printf("Кот %s сыт! Сытость: %d из %d%n",name, actualAppetite, maxAppetite);
        } else {
            System.out.printf("Кот %s голоден! Сытость: %d из %d%n",name, actualAppetite, maxAppetite);
        }
    }


}
