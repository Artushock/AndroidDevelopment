package java_core_for_android.lesson7_oop;
/*
    @author Artiom Ponomariov
*/

import java.util.Random;

public class CatsShelter {
    private final Random random = new Random();

    private static int numberOfShelter = 1;
    private static final int DEFAULT_MAX_FOOD_IN_STORAGE = 500;
    private static final int MIN_AMOUNT_OF_FOOD_IN_BOWL = 20;
    private static final int DEFAULT_MAX_AMOUNT_OF_CATS = 25;
    private static final int DEFAULT_MAX_AMOUNT_OF_BOWLS = 40;

    private Cat[] cats;
    private Bowl[] bowls;

    private int amountOfCats;
    private int amountOfBowls;
    private int foodInStorage;

    private String shelterName;

    private final int  maxFoodInStorage;
    private final int  maxAmountOfCats;


    public CatsShelter() {
        this(DEFAULT_MAX_AMOUNT_OF_CATS, DEFAULT_MAX_FOOD_IN_STORAGE);
    }

    public CatsShelter(int maxAmountOfCats){
        this(maxAmountOfCats, DEFAULT_MAX_FOOD_IN_STORAGE);
    }

    public CatsShelter(int maxAmountOfCats, int maxFoodInStorage) {
        this.maxAmountOfCats = maxAmountOfCats;
        this.maxFoodInStorage = maxFoodInStorage;
        this.shelterName = "Приют № " + numberOfShelter++;
        cats = new Cat[maxAmountOfCats];
        bowls = new Bowl[DEFAULT_MAX_AMOUNT_OF_BOWLS];
    }


    public void addCats(Cat[] cats){
        for(Cat cat : cats){
            addCat(cat);
        }
    }

    public void addBowls(Bowl[] bowls){
        for (Bowl bowl : bowls){
            addBowl(bowl);
        }
    }

    private void addCat(Cat cat){
        if (addElement(cats, cat)) {
            amountOfCats++;
            return;
        }
        printError("Кота " + cat.getName() + " принять некуда.");
    }

    private void addBowl(Bowl bowl){
        if (addElement(bowls, bowl)) {
            amountOfBowls++;
            return;
        }
        printError("Количество мисок превышено!");
    }

    private boolean addElement(Object[] objects, Object object) {
        for (int i = 0; i < objects.length; i++){
            if (objects[i] == null) {
                objects[i] = object;
                return true;
            }
        }
        return false;
    }


    public void addFoodToStorage(int someFood){
        if (maxFoodInStorage-foodInStorage > someFood){
            foodInStorage += someFood;
        } else {
            foodInStorage = maxFoodInStorage;
        }
    }


    public void feedCats(){
        if(isFoodInBowlLess(MIN_AMOUNT_OF_FOOD_IN_BOWL) && foodInStorage != 0){
            fillBowls();
            printBowlsInfo();
        }

        for (int i = 0; i < amountOfCats; i++) {
            cats[i].eat(getBowl());
        }

        for (int i = 0; i < amountOfBowls; i++) {
            bowls[i].setBusy(false);
        }
    }

    private void fillBowls(){

        int takenFromStorage = 0;

        for (int i = 0; i < amountOfBowls; i++) {
            if (foodInStorage != 0) {
                int requiredAmount = bowls[i].getBowlFreeVolume();
                if (foodInStorage > requiredAmount) {
                    foodInStorage -= requiredAmount;
                    takenFromStorage +=requiredAmount;
                    bowls[i].addFoodToBowl(requiredAmount);
                } else {
                    bowls[i].addFoodToBowl(foodInStorage);
                    takenFromStorage += foodInStorage;
                    foodInStorage = 0;
                }
            }
        }
        System.out.println();
        System.out.println("Со склада взято " + takenFromStorage + " еды.\nТекущий остаток: " + foodInStorage);
        if (foodInStorage <= 0){
            printError("На складе закончилась еда!");
        }
    }

    private Bowl getBowl() {
        for (int i = 0; i < amountOfBowls; i++) {
            if (!bowls[i].isBusy() && bowls[i].isThereFoodInBowl()) {
                bowls[i].setBusy(true);
                return bowls[i];
            }
        }

        for (int i = 0; i < amountOfBowls; i++) {
            if (bowls[i].isThereFoodInBowl()) {
                bowls[i].setBusy(true);
                return bowls[i];
            }
        }

        return null;
    }


    private boolean isFoodInBowlLess(int amount) {
        for (int i = 0; i < amountOfBowls; i++) {
            if(bowls[i].getAmountOfFood() <= amount){
                return true;
            }
        }
        return false;
    }


    public boolean isThereFood(){
        return isBowlsEmpty(0) && foodInStorage == 0;
    }

    private boolean isBowlsEmpty(int amount) {
        for (int i = 0; i < amountOfBowls; i++) {
            if(bowls[i].getAmountOfFood() > 0){
                return false;
            }
        }
        return true;
    }

    public void printCatsInfo(){
        System.out.println();
        for (int i = 0; i < amountOfCats; i++) {
            System.out.println(cats[i]);
        }
    }

    public void printBowlsInfo(){
        System.out.println();
        for (int i = 0; i < amountOfBowls; i++) {
            System.out.println(bowls[i]);
        }
    }

    public void printInfo(){
        System.out.println();
        System.out.println("Информация про " + shelterName);
        System.out.println("Кол-во котов: " + amountOfCats + " из " + maxAmountOfCats);
        System.out.println("Кол-во мисок: " + amountOfBowls + " из " + DEFAULT_MAX_AMOUNT_OF_BOWLS);
        System.out.println("Кол-во еды на складе: " + foodInStorage + " из " + maxFoodInStorage);
    }

    private void printError(String s){
        System.err.println(s);
    }
}
