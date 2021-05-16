package java_core_for_android.lesson2_main_constructions;/*
    @author Artiom Ponomariov
*/

public class HomeWork_2_1 {
    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1};
        for (int i=0; i<arr.length; i++){
            arr[i] = arr[i] == 1 ? 0 : 1;
        }

        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
