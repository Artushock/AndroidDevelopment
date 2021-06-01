package java_core_for_android.lesson6_oop_advanced;
/*
    @author Artiom Ponomariov
*/

public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat("Васька");
        Animal dog = new Dog("Бобик");

        cat.run(100);
        cat.swim(5);

        dog.run(350);
        dog.swim(50);

        System.out.println("Количество животных: " + Animal.amountOfAnimals);
        System.out.println("Количество котов: " + Cat.amountOfCats);
        System.out.println("Количество собак: " + Dog.amountOfDogs);
    }
}
