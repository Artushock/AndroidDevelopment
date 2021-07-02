package java_core_for_android.lesson14_development_tools_overview;

import java.util.stream.IntStream;

/*@author Artiom Ponomariov*/
public class DevToolsMain {
    private static final int NUM_ONE = 1;
    private static final int NUM_FOUR = 4;

    public static void main(String[] args) {
    }

    public int[] getAfterLastFour(int[] arr) {
        if (IntStream.of(arr).noneMatch(x -> x == 4)) throw new RuntimeException("Number " + NUM_FOUR + " is absent!");

        int l = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != NUM_FOUR) {
                l++;
            } else break;
        }

        int[] result = new int[l];
        int count = 0;
        for (int i = (arr.length - l); i < arr.length; i++) {
            result[count++] = arr[i];
        }
        return result;
    }

    public boolean findOneAndFour(int[] arr) {
        return IntStream.of(arr).allMatch(x -> x == NUM_ONE || x == NUM_FOUR)
                && !IntStream.of(arr).allMatch(x -> x == NUM_ONE)
                && !IntStream.of(arr).allMatch(x -> x == NUM_FOUR);
    }
}
