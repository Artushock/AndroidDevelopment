package java_core_for_android.lesson2_main_constructions;
/*
    @author Artiom Ponomariov
*/

public class HomeWork_2_4 {
    private static final int arrSize = 5;

    public static void main(String[] args) {
        int[][] arr = new int[arrSize][arrSize];

        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
               if (i == j || i+j == 4) arr[i][j] = 1;
            }
        }

        // print
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
