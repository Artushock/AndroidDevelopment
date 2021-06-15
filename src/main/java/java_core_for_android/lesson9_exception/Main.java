package java_core_for_android.lesson9_exception;
/*
    @author Artiom Ponomariov
*/

public class Main {
    private static final int ARR_LENGHT = 4;
    static String[][] strings;

    public static void main(String[] args) {
        strings = stringsFill();

        try {
            System.out.println("Сумма элементов массива: " + sumStringArray(strings));
        } catch (MyArrayDataException | MySizeArrayException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String[][] stringsFill() {
        strings = new String[ARR_LENGHT][ARR_LENGHT];
//        strings = new String[ARR_LENGHT][5];
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                strings[i][j] = (i+j)*(i*j)+"";
            }
        }
//        strings[2][2] = null;
//        strings[3][3] = "null";
        return strings;
    }

    protected static int sumStringArray(String[][] strings) throws MyArrayDataException, MySizeArrayException {

        if (strings.length != ARR_LENGHT || strings[0].length != ARR_LENGHT) {
            throw new MySizeArrayException("Некорректная длинна массива");
        }

        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                String string = strings[i][j];
                int numeber = 0;
                try {
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Некорректные данные в ячейке: [%d][%d]",i, j));
                }
                sum += numeber;
            }
        }
        return sum;
    }
}
