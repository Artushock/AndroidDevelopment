package java_core_for_android.lesson2_practice;

/*
    @author Artiom Ponomariov
*/

import java.util.Random;
import java.util.Scanner;

public class HomeWork_3_1 {
    private static Random random = new Random();
    private static Scanner in = new Scanner(System.in);

    private static final int AMOUNT_OF_ATTEMPTS = 3;

    public static void main(String[] args) {
        System.out.println("Угадай число");

        boolean isGame = true;

        while (isGame){
            int randomNumber = random.nextInt(10);
            startGame(randomNumber);
            isGame = repeatGame(isGame);
        }
    }

    private static void startGame(int randomNumber) {
        int userNumber;
        int attempt = AMOUNT_OF_ATTEMPTS;

        for (int i = 0; i < AMOUNT_OF_ATTEMPTS; i++){
            userNumber = getUserNumber();
            System.out.println();

            if (userNumber == randomNumber){
                System.out.println("Поздравляем! Вы угадали");
                break;
            } else if (userNumber < randomNumber){
                System.out.printf("Вы ввели число %d. Это меньше чем загаданное число.%n", userNumber);

            } else {
                System.out.printf("Вы ввели число %d. Это больше чем загаданное число.%n", userNumber);
            }

            if (--attempt>0){
                System.out.printf("Осталось %d попыток.%n", i);
            } else {
                System.out.printf("Попытки закончились! Правильный ответ: %d. %n", randomNumber);
            }
        }
    }



    private static int getUserNumber() {
        System.out.print ("Введите число от 0 до 9: ");
        int number = 0;
        boolean isInt = false;
        do {
            if(in.hasNextInt()){
                number = in.nextInt();
                isInt = true;
            } else {
                in.next();
                System.out.print ("Некорректный ввод! ");
                System.out.print ("Введите число от 0 до 9: ");
            }
        } while (!isInt);
        return number;
    }

    private static boolean repeatGame(boolean isGame) {
        System.out.println();
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет ");
        switch (in.nextInt()){
            case 1 :
                break;
            case 0 :
                isGame = false;
                System.out.println("До встречи!");
                break;
            default:
                System.out.println("Введен некорректный ответ!");
        }
        return isGame;
    }
}
