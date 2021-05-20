package java_core_for_android.lesson2_main_constructions;
/*
    @author Artiom Ponomariov
*/

public class HomeWork_2_4 {
    private static final int arrSize = 15;

    public static void main(String[] args) {
        int[][] arr = new int[arrSize][arrSize];

        // my realistion
        //for (int i = 0; i < arr.length; i++) {
        //    for (int j = 0; j < arr.length; j++) {
        //      if (i == j || i+j == arr.length-1) arr[i][j] = 1;
        //   }
        //}

        //correct answer
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length-1-i] = 1;
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
