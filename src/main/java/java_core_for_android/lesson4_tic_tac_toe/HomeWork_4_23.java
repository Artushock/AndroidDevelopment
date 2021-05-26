package java_core_for_android.lesson4_tic_tac_toe;
/*
    @author Artiom Ponomariov
*/

import java.util.Random;
import java.util.Scanner;

public class HomeWork_4_23 {

    private static final int SIZE = 5;
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
                boolean isPlayerWin;
                isPlayerWin = humanTurn();
                printMap();

                if(isPlayerWin){
                    System.out.println("Человек победил!");
                    break;
                }
                if(isMapFull(map)){
                    System.out.println("Ничья!");
                    break;
                }

                isPlayerWin = aiTurn();
                printMap();
                if(isPlayerWin){
                    System.out.println("Победил компьютер!");
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

    private static boolean humanTurn() {
        int rowNumber, columnNumber;
        System.out.println("Ход человека");

        do {
            rowNumber = getNumber("строки: ")-1;
            columnNumber = getNumber("колонки: ")-1;
        } while (isCoordinatesWrong(rowNumber, columnNumber));

        map[rowNumber][columnNumber] = DOT_X;
        turns++;
        return isTurnWin(DOT_X, rowNumber, columnNumber);
    }

    private static boolean aiTurn() {
        int rowNumber, columnNumber;
        System.out.println("Ход компьтера");

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (isCoordinatesWrong(rowNumber, columnNumber));

        map[rowNumber][columnNumber] = DOT_O;
        turns++;
        return isTurnWin(DOT_O, rowNumber, columnNumber);
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

    /*private static boolean isPlayerWin(char c) {
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
    }*/

    private static boolean isTurnWin(char c, int x, int y){
        int counter;
        int startCountX;
        int endCountX;
        int startCountY;
        int endCountY;


        // check row
        startCountY = y - (DOTS_TO_WIN - 1);
        endCountY = y + (DOTS_TO_WIN -1);
        while (startCountY < 0){
            startCountY++;
        }
        while (endCountY >= SIZE){
            endCountY--;
        }
        counter = 0;
        for (int i = startCountY; i <= endCountY; i++) {
            if (map[x][i] == c){
                counter++;
                if (counter == DOTS_TO_WIN){
                    return true;
                }
            } else {
                counter = 0;
            }
        }

        //check columns
        startCountX = x - (DOTS_TO_WIN - 1);
        endCountX = x + (DOTS_TO_WIN -1);
        while (startCountX < 0){
            startCountX++;
        }
        while (endCountX >= SIZE){
            endCountX--;
        }
        counter = 0;
        for (int i = startCountX; i <= endCountX; i++) {
            if (map[i][y] == c){
                counter++;
                if (counter == DOTS_TO_WIN){
                    return true;
                }
            } else {
                counter = 0;
            }
        }

        //check diagonal#1
        startCountX = x - (DOTS_TO_WIN - 1);
        startCountY = y - (DOTS_TO_WIN - 1);
        endCountX = x + (DOTS_TO_WIN - 1);
        endCountY = y + (DOTS_TO_WIN - 1);

        while (startCountX < 0 || startCountY < 0){
            startCountX++;
            startCountY++;
        }
        while (endCountX >= SIZE || endCountY >= SIZE){
            endCountX--;
            endCountY--;
        }
        counter = 0;
        for (int i = 0; i <= Math.abs(endCountX-startCountX); i++) {
            if (map[startCountX+i][startCountY+i]==c){
                counter++;
                if (counter == DOTS_TO_WIN){
                    return true;
                }
            } else {
                counter = 0;
            }
        }

        //check diagonal#2
        startCountX = x + (DOTS_TO_WIN - 1);
        startCountY = y - (DOTS_TO_WIN - 1);
        endCountX = x - (DOTS_TO_WIN -1);
        endCountY = y + (DOTS_TO_WIN -1);

        while (startCountX >= SIZE || startCountY < 0){
            startCountX--;
            startCountY++;
        }
        while (endCountX < 0 || endCountY >= SIZE){
            endCountX++;
            endCountY--;
        }

        counter = 0;
        for (int i = 0; i <= Math.abs(endCountX-startCountX); i++) {
            if (map[startCountX-i][startCountY+i]==c){
                counter++;
                if (counter == DOTS_TO_WIN){
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }
}
