package java_core_for_android.lesson2_main_constructions;/*
    @author Artiom Ponomariov
*/

public class HomeWork_2_6 {

    public static void main(String[] args) {

        int[] arr = {2, 1, 2, 3, 3};

        boolean isBalanced = checkBalance(arr);
        System.out.println(isBalanced);
    }

    private static boolean checkBalance(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum +=n;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum/2;
        for (int n : arr){
            sum = sum - n;
            if (sum <= 0) {
                break;
            }
        }
        return sum == 0;
    }
}
