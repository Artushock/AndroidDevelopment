package java_core_for_android.lesson2_main_constructions;
/*
    @author Artiom Ponomariov
*/

public class HomeWork_2_2 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        int arg = 0;

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = arg;
            arg+=3;
        }

        //print
        for (int n : arr){
            System.out.print(n + " ");
        }
    }
}
