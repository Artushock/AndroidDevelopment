package java_core_for_android.lesson12_multithreading_first_part;

import java.util.Arrays;

/*@author Artiom Ponomariov*/
public class MultithreadingHomeWorkOne {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    static final int BALLAST = SIZE % 2;


    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        firstMethod(arr);
        //printArray(arr);

        arr = new float[SIZE];
        secondMethod(arr);
        //printArray(arr);
    }

    private static void firstMethod(float[] arr) {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        fillArrayWithFormula(arr, 0);
        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis()-a) + " мс");
    }

    private static void secondMethod(float[] arr) {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        float[] firstArrayPart = new float[HALF + BALLAST];
        float[] secondArrayPart = new float[HALF];

        System.arraycopy(arr, 0, firstArrayPart, 0, firstArrayPart.length);
        System.arraycopy(arr, HALF+BALLAST, secondArrayPart, 0, secondArrayPart.length);

        Thread thread1 = new Thread(() ->
            fillArrayWithFormula(firstArrayPart, 0)
        );

        Thread thread2 = new Thread(() ->
            fillArrayWithFormula(secondArrayPart, HALF + BALLAST)
        );

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstArrayPart, 0, arr,0, HALF+BALLAST);
        System.arraycopy(secondArrayPart, 0, arr, HALF+BALLAST, secondArrayPart.length);

        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis()-a) + " мс");
    }

    private static void fillArrayWithFormula(float[] arr, int add ) {
        float j;
        for (int i = 0; i < arr.length; i++) {
            j = i+add;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }

    private static void printArray(float[] arr) {
        for (float f : arr) {
            System.out.printf("%.2f ", f);
        }
        System.out.println();
    }
}
