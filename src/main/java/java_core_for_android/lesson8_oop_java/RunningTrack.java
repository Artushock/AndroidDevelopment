package java_core_for_android.lesson8_oop_java;
/*
    @author Artiom Ponomariov
*/

public class RunningTrack implements SportsObstacle {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean overcomeObstacle(Competitor competitor) {
        return competitor.run(length);
    }

    @Override
    public String toString() {
        return "Беговая дорожка " + length + " м";
    }
}
