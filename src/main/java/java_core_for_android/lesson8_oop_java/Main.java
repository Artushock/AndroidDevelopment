package java_core_for_android.lesson8_oop_java;
/*
    @author Artiom Ponomariov
*/

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors = {
                new Cat("Мурзик", 1100, 150),
                new Human("Анатолий", 5000, 60),
                new Robot("R2D2", 20000, 0)
        };

        SportsObstacle[] sportsObstacles = {new RunningTrack(5000), new Obstacle(80), new Obstacle(50)};

        for (Competitor competitor : competitors){
            System.out.println();
            System.out.println(competitor + " на старте.");

            for (SportsObstacle sportsObstacle : sportsObstacles){
                String s = sportsObstacle.overcomeObstacle(competitor) ? " преодолел " : " не смог преодолеть ";
                System.out.println(competitor.toString() + s + sportsObstacle.toString().toLowerCase());
            }
        }
    }
}
