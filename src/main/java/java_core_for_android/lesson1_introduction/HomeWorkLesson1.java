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
        System.out.printf("Expression calculation  result is: %.3f ", expressionResult);

        // 4.

    }

    private static float calculateExpression (float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
}
