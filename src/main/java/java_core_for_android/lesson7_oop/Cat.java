package java_core_for_android.lesson7_oop;
/*
    @author Artiom Ponomariov
*/

import java.util.Formatter;
import java.util.Random;

public class Cat {
    private final String name;
    private final Random random = new Random();
    private boolean satiety = false;
    private int actualAppetite = 0;
    private int maxAppetite = 0;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean eat(Bowl bowl) {
        maxAppetite = random.nextInt(4) + 3;
        if (bowl != null){
            actualAppetite = bowl.decreaseFood(maxAppetite);
            return satiety = maxAppetite == actualAppetite;
        } else {
            satiety = false;
            actualAppetite = 0;
            return false;
        }

    }

    @Override
    public String toString() {
        StringBuilder catInfo = new StringBuilder("Кот " + name);
        String s;
        if (satiety){
            s = " cыт. " + actualAppetite +"/" + maxAppetite + ".";
        } else if (maxAppetite == 0) {
           s = " не обедал.";
        } else {
            s = " голоден. " + actualAppetite +"/" + maxAppetite + ".";
        }
        return catInfo.append(s).toString();
    }
}
