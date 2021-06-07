package java_core_for_android.lesson7_oop;
/*
    @author Artiom Ponomariov
*/

public class Plate {
    private int amountOfFood;

    public Plate(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void addFoodToPlate(int someFood){
        System.out.println("Добавлено " + someFood + " еды.");
        amountOfFood +=someFood;
    }

    public void printInfo() {
        System.out.println("В тарелке: " + amountOfFood + " еды.");
    }

    public int decreaseFood(int i) {
        amountOfFood -= i;
        return amountOfFood > 0 ? i : i+amountOfFood;
    }
}
