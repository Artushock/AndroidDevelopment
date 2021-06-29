package java_core_for_android.lesson13_multithreading_second_part;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
