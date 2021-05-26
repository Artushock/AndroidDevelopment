package java_core_for_android.lesson2_practice;

/*
    @author Artiom Ponomariov
*/

import java.util.Random;
import java.util.Scanner;

public class HomeWork_3_2 {
    private static Random random = new Random();
    private static Scanner in = new Scanner(System.in);
    private static int MAX_AMOUNT_OF_SYMBOLS = 15;

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String randomWord = words[random.nextInt(words.length)];
        System.out.println("Enter fruit or vegetable: ");
        boolean isGuessed = false;

        do {
            String userWord = in.nextLine().toLowerCase().trim();
            if (userWord.trim().equals(randomWord)){
                System.out.printf("Great! Right answer is: %s%n",randomWord);
                isGuessed = true;
            } else {
                System.out.println(checkWord(randomWord, userWord));
            }
        } while (!isGuessed);
    }

    private static String checkWord(String rw, String uw) {
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(rw.length(), uw.length());
        for (int i = 0; i < minLength; i++) {
            if(rw.charAt(i)==uw.charAt(i)){
                result.append(uw.charAt(i));
            } else {
                result.append('#');
            }
        }
        result.append("#".repeat(MAX_AMOUNT_OF_SYMBOLS-minLength));

        return result.toString();
    }
}
