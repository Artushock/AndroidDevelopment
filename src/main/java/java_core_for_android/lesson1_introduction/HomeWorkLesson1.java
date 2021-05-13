package java_core_for_android.lesson1_introduction;
/*
    @author Artiom Ponomariov
*/

public class HomeWorkLesson1 {
    public static void main(String[] args) {
        // 2.
        byte byteVar = 120;
        short shortVar = 10000;
        int intVar = 123;
        long longVar = 1000000L;

        float floatVar = 3.14f;
        double doubleVar = 123.456;

        char charVar = 'c';

        boolean isItTrue = false;

        String strVar = "Geek Brains!";

        // 3.
        float expressionResult = calculateExpression (1.1f, 2.2f, 3.3f, 4.4f);
        System.out.printf("Expression calculation  result is: %.3f.%n", expressionResult);

        // 4.
        boolean checkSumRangeResult = checkSumRange(5, 5);
        System.out.printf("The sum of the numbers in the range from 10 to 20 is %b.%n", checkSumRangeResult);

        //5.
        checkSignOfNum(0);

        // 6.
        boolean isNumPositive = checkSignOfNumber(-1);
        System.out.println(isNumPositive);

        //7.
        String name = "Артем";
        printHello(name);

    }

    private static float calculateExpression (float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean checkSumRange(int a, int b) {
        return (a+b >= 10 && a+b <=20) ;
    }

    private static void checkSignOfNum(int i) {
        if (i>=0) System.out.println("I've got positive number.");
        else System.out.println("I've got negative number.");
    }

    private static boolean checkSignOfNumber(int i) {
        return !(i>=0);
    }

    private static void printHello(String name) {
        System.out.printf("Привет, %s!%n", name);
    }
}
