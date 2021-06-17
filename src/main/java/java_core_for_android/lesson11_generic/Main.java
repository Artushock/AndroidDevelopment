package java_core_for_android.lesson11_generic;

import java_core_for_android.lesson11_generic.fruits.Apple;
import java_core_for_android.lesson11_generic.fruits.Box;
import java_core_for_android.lesson11_generic.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

/*@author Artiom Ponomariov*/
public class Main {
    public static void main(String[] args) {
        swapElementsTest(); //1
        convertToArrayListTest(); //2
        fruitTest(); //3
    }

    private static void swapElementsTest() {
        Integer[] intArray = {3, 5, 7, 8, 12};
        String[] stringArray = {"Петя", "Вася", "Коля", "Андрей"};

        System.out.println(Arrays.toString(stringArray));
        ArrayUtil.swapElements(stringArray, 1,3);
        System.out.println(Arrays.toString(stringArray));

        System.out.println(Arrays.toString(intArray));
        ArrayUtil.swapElements(intArray, 1,3);
        System.out.println(Arrays.toString(intArray));
    }

    private static void convertToArrayListTest() {
        Integer[] intArray = {3, 5, 7, 8, 12};
        String[] stringArray = {"Петя", "Вася", "Коля", "Андрей"};

        ArrayList<Integer> integerArrayList = ArrayUtil.convertToArrayList(intArray);
        ArrayList<String> stringArrayList = ArrayUtil.convertToArrayList(stringArray);
        integerArrayList.add(34);
        stringArrayList.add("Миша");
        System.out.println(integerArrayList);
        System.out.println(stringArrayList);
    }

    private static void fruitTest() {
        Apple[] apples = {new Apple(), new Apple(),new Apple()};
        Orange[] oranges = {new Orange(), new Orange(), new Orange(), new Orange()};
        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);

        appleBox.addFruit(new Apple());
        orangeBox.addFruit(new Orange());
//        appleBox.addFruit(new Orange());
//        orangeBox.addFruit(new Apple());

        if (appleBox.compare(orangeBox)){
            System.out.println("Ящик с яблоками тяжелее ящика с апельсинами");
        } else {
            System.out.println("Ящик с яблоками легче ящика с апельсинами");
        }

        appleBox.addFruit(new Apple());
        orangeBox.addFruit(new Orange());

        Box<Apple> newAppleBox = new Box<>();
        System.out.println("Вес ящика с яблоками " + appleBox.getWeight() + " кг.");
        System.out.println("Вес нового ящика для яблок " + newAppleBox.getWeight() + " кг.");
        appleBox.pourAppleTo(newAppleBox);
//        orangeBox.pourAppleTo(newAppleBox);
        System.out.println("Вес ящика с яблоками " + appleBox.getWeight() + " кг.");
        System.out.println("Вес нового ящика для яблок " + newAppleBox.getWeight() + " кг.");
    }

    public static class ArrayUtil<T>{
        public static <T> void swapElements(T[] array, int firstElementIndex, int secondElementIndex){
            if(firstElementIndex >= array.length || secondElementIndex >= array.length){
                throw new IllegalArgumentException();
            }

            T tempElement = array[firstElementIndex];
            array[firstElementIndex] = array[secondElementIndex];
            array[secondElementIndex] = tempElement;
        }

        public static <T> ArrayList<T> convertToArrayList(T[] array){
            return new ArrayList<>(Arrays.asList(array));
        }

    }
}
