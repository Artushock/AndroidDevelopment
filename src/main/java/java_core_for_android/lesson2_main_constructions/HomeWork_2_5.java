package java_core_for_android.lesson2_main_constructions;
/*
    @author Artiom Ponomariov
*/
public class HomeWork_2_5 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, -23, 1};
        int max = arr[0];
        int min = arr[0];

        for (int n : arr){
            if (n > max) max = n;
            if (n < min) min = n;
        }

        //print
        System.out.println("max = " + max);
        System.out.println("min = " + min);

    }
}
