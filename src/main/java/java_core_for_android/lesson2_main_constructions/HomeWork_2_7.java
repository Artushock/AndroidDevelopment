package java_core_for_android.lesson2_main_constructions;
/*
    @author Artiom Ponomariov
*/

public class HomeWork_2_7 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        arr = shiftArray(arr, 1);

        //print
        for (int n: arr) {
            System.out.print(n + " ");
        }
    }

    private static int[] shiftArray(int[] arr, int n) {
        if (n == 0 || Math.abs(n) == arr.length) return arr;
        if (Math.abs(n)>arr.length) n = n % arr.length;

        if (n>0){
            for (int i=0; i<n; i++){
                arr = shiftOneStep(arr);
            }
        } else {
            for (int i=0; i<arr.length+n; i++){
                arr = shiftOneStep(arr);
            }
        }
        return  arr;
    }

    private static int[] shiftOneStep(int[] arr) {
        int a = arr[0], b;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1){
                b = arr[i+1];
                arr[i+1] = a;
                a = b;
            } else {
                arr[0] = a;
            }
        }
        return arr;
    }
}
