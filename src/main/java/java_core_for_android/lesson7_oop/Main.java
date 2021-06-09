package java_core_for_android.lesson7_oop;
/*
    @author Artiom Ponomariov
*/

public class Main {
    public static void main(String[] args) {

        CatsShelter catsShelter = new CatsShelter();

        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Барсик"),
                new Cat("Рыжий")
        };
        catsShelter.addCats(cats);


        Bowl[] bowls = {
                new Bowl(),
                new Bowl(100, "Green"),
                new Bowl("Red"),
                new Bowl(70, "Black")
        };
        catsShelter.addBowls(bowls);
        catsShelter.addFoodToStorage(350);

        catsShelter.printInfo();
        catsShelter.printBowlsInfo();
        catsShelter.printCatsInfo();

        while (catsShelter.isThereFood()) {
            catsShelter.feedCats();
            catsShelter.printBowlsInfo();
            catsShelter.printCatsInfo();
        }

        catsShelter.printInfo();

    }
}
