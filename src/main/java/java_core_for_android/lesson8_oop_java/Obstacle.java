package java_core_for_android.lesson8_oop_java;
/*
    @author Artiom Ponomariov
*/

public class Obstacle implements SportsObstacle {
    private int height;

    public Obstacle(int height) {
        this.height = height;
    }

    @Override
    public boolean overcomeObstacle(Competitor competitor) {
        return competitor.leap(height);
    }

    @Override
    public String toString() {
        return "Препятствие " + height + " см";
    }
}
