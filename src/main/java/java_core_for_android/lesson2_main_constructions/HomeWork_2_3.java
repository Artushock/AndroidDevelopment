package java_core_for_android.lesson2_main_constructions;/*
    @author Artiom Ponomariov
*/

public class HomeWork_2_3 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = arr[i]<6 ? arr[i]*2 : arr[i];
        }

        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
