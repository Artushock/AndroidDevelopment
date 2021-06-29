package java_core_for_android.lesson9_exception;/*
    @author Artiom Ponomariov
*/

public class MyArrayDataException extends IllegalArgumentException {
    public MyArrayDataException(String s) {
        super(s);
    }
}
