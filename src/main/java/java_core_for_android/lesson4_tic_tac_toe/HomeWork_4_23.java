package java_core_for_android.lesson4_tic_tac_toe;
/*
    @author Artiom Ponomariov
*/

import java.util.Random;
import java.util.Scanner;

public class HomeWork_4_23 {

    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char FIRST_SYMBOL = '☻';

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    private static char[][]map;
    private static int turns;

    public static void main(String[] args) {


        do {
            initGame();
            printMap();
            while (true){
                humanTurn();
                printMap();

                if(isPlayerWin(DOT_X)){
                    System.out.println("Человек победил!");
                    break;
                }
                if(isMapFull(map)){
                    System.out.println("Ничья!");
                    break;
                }

                aiTurn();
                printMap();

                if(isPlayerWin(DOT_O)){
                    System.out.println("Человек компьютер!");
                    break;
                }
                if(isMapFull(map)){
                    System.out.println("Ничья!");
                    break;
                }
            }
        } while (isContinueGame());
    }

    private static boolean isContinueGame() {
        do {
            System.out.print("Желаете сыграть еще? да/нет: ");
            String answer = in.next();
            if (answer.equals("да")){
                return true;
            } else if (answer.equals("нет")){
                System.out.println("Конец игры");
                return false;
            } else {
                System.out.println("Ответ введен некорреткно!");
            }
        } while (true);
    }

    private static void initGame() {
        turns = 0;
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE ; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        System.out.printf("%3s", FIRST_SYMBOL);
        for (int i = 1; i <= SIZE ; i++) {
            System.out.printf("%3s", i);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%3s", i+1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%3s", map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isMapFull(char[][] map) {
        return turns == SIZE*SIZE;
    }

    private static void humanTurn() {
        int rowNumber, columnNumber;
        System.out.println("Ход человека");

        do {
            rowNumber = getNumber("строки: ")-1;
            columnNumber = getNumber("колонки: ")-1;
        } while (isCoordinatesWrong(rowNumber, columnNumber));

        map[rowNumber][columnNumber] = DOT_X;
        turns++;
    }

    private static void aiTurn() {
        int rowNumber, columnNumber;
        System.out.println("Ход компьтера");

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (isCoordinatesWrong(rowNumber, columnNumber));

        map[rowNumber][columnNumber] = DOT_O;
        turns++;
    }

    private static int getNumber(String str) {
        int number = -1;
        boolean isNumber = false;
        do {
            System.out.print("Введите номер " + str);
            if(in.hasNextInt()){
                number = in.nextInt();
                isNumber = true;
            } else {
                in.next();
            }
        } while (!isNumber);
        return number;
    }

    private static boolean isCoordinatesWrong(int rowNumber, int columnNumber) {
        if(rowNumber < 0 || columnNumber < 0 || rowNumber >= SIZE || columnNumber >= SIZE){
            return true;
        }
        return map[rowNumber][columnNumber] != DOT_EMPTY;
    }

    private static boolean isPlayerWin(char c) {
        int counter = 0;
        //check row
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == c){
                    counter++;
                    if(counter == DOTS_TO_WIN){
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }

        //check column
        for (int i = 0; i < SIZE; i++){
            counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if(map[j][i] == c){
                    counter++;
                    if(counter == DOTS_TO_WIN){
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }

        //check diagonal #1
        counter = 0;
        for (int i = 0; i < SIZE; i++){
            if(map[i][i] == c){
                counter++;
                if(counter == DOTS_TO_WIN){
                    return true;
                }
            } else {
                counter = 0;
            }
        }

        //check diagonal #2
        counter = 0;
        for (int i = 0; i < SIZE; i++){
            if(map[i][SIZE - i -1] == c){
                counter++;
                if(counter == DOTS_TO_WIN){
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }
}
