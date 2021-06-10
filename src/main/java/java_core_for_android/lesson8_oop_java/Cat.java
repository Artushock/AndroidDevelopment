package java_core_for_android.lesson8_oop_java;
/*
    @author Artiom Ponomariov
*/

public class Cat implements Competitor {
    private String name;
    private int maxDistance;
    private int maxHeight;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean leap(int height) {
        return height<maxHeight;
    }

    @Override
    public boolean run(int distance) {
        return distance<=maxDistance;
    }

    @Override
    public String toString() {
        return ("Кот " + name);
    }
}
