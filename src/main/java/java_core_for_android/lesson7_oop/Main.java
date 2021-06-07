package java_core_for_android.lesson7_oop;
/*
    @author Artiom Ponomariov
*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Барсик"),
                new Cat("Рыжий")
        };
        Plate plate = new Plate(70);

        plate.printInfo();
        feedCat(cats, plate);

        plate.addFoodToPlate(50);
        feedCat(cats, plate);
    }

    private static void feedCat(Cat[] cats, Plate plate) throws InterruptedException {
        while (plate.getAmountOfFood() > 0) {
            for (Cat cat : cats) {
                cat.eat(plate);
                cat.satietyInfo();
            }
            plate.printInfo();
            Thread.sleep(200);
        }
    }
}
