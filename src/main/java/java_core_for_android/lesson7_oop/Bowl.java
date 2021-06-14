package java_core_for_android.lesson7_oop;
/*
    @author Artiom Ponomariov
*/

import java.util.Formatter;

public class Bowl {
    private static int numberOfBowl = 1;
    private static final int DEFAULT_BOWL_VOLUME = 50;
    private static final String DEFAULT_COLOR = "White";

    private final String name;
    private final String bowlColor;
    private int amountOfFood = 0;
    private final int bowlVolume;
    private boolean isBusy = false;

    public Bowl(int bowlVolume, String color) {
        this.name = "Миска №" + numberOfBowl++;
        this.bowlVolume = bowlVolume;
        this.bowlColor = color;
    }

    public Bowl(String color) {
        this(DEFAULT_BOWL_VOLUME, color);
    }

    public Bowl(int bowlVolume) {
        this(bowlVolume, DEFAULT_COLOR);
    }

    public Bowl() {
        this(DEFAULT_BOWL_VOLUME, DEFAULT_COLOR);
    }


    public int getAmountOfFood() {
        return amountOfFood;
    }

    public int getBowlFreeVolume(){
        return bowlVolume - amountOfFood;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public boolean isThereFoodInBowl(){
        return amountOfFood != 0;
    }


    public void addFoodToBowl(int someFood){
        if (someFood <= bowlVolume - amountOfFood){
            amountOfFood +=someFood;
        } else {
            System.err.println("Количество еды превышет допстимое!");
        }
    }

    public int decreaseFood(int i) {
        amountOfFood -= i;
        if (amountOfFood >= 0){
            return i;
        } else {
            i = i+amountOfFood;
            amountOfFood = 0;
            return i;
        }
    }

    @Override
    public String toString() {
       return new Formatter().format("%s / %s / Еда: %d из %d", name, bowlColor, amountOfFood, bowlVolume).toString();
    }
}
