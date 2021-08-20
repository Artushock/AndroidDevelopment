package java_core_for_android.lesson10_collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*@author Artiom Ponomariov*/
public class MainCollections {
    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    private static void firstTask() {
        String[] shoppingList = {"Яблоки", "Бананы", "Огурцы", "Сосиски", "Соус", "Молоко",
                "Яблоки", "Йогурт", "Хлеб", "Печенье", "Колбаса", "Масло", "Пиво", "Рыба", "Йогурт",
                "Бананы", "Колбаса", "Рыба", "Пиво", "Хлеб", "Сосиски", "Хлеб", "Рыба", "Огурцы", "Пиво", "Сосиски",};
        Set<String> stringSet = new HashSet<>(Arrays.asList(shoppingList));

        for (String s : stringSet) {
            int amount = 0;
            for (String str : shoppingList) {
                if (s.equals(str)) {
                    amount++;
                }
            }
            System.out.println(s + ": " + amount);
        }
    }

    private static void secondTask() {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Алексеев", "38(099) 678-43-45");
        phonebook.add("Пушкин", "38(093) 757-76-98");
        phonebook.add("Пушкин", "38(093) 433-33-22");
        phonebook.add("Пушкин", "38(093) 757-76-98");
        phonebook.add("Пушкин", "38(093) 433-33-22");

        System.out.println(phonebook.get("Алексеев"));
        System.out.println(phonebook.get("Пушкин"));
    }
}
