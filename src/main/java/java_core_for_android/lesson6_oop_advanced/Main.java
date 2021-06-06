package java_core_for_android.lesson6_oop_advanced;
/*
    @author Artiom Ponomariov
*/

public class Main {

    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Васька"),
                new Dog("Бобик"),
                new Cat("Мурзик", 300, 15),
                new Dog("Бобик", 1000, 50)
        };

        for (Animal animal : animals){
            animal.run(200);
            animal.swim(5);
        }

        System.out.println();
        System.out.println("Количество животных: " + Animal.amountOfAnimals);
        System.out.println("Количество котов: " + Cat.amountOfCats);
        System.out.println("Количество собак: " + Dog.amountOfDogs);
    }
}
