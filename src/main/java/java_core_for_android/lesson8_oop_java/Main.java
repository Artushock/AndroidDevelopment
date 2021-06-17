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

        SportsObstacle[] sportsObstacles = {
                new RunningTrack(1000),
                new Obstacle(80),
                new Obstacle(50),
        };

        for (Competitor competitor : competitors){
            System.out.println();
            System.out.println(competitor + " на старте.");
            boolean isFinished = true;

            for (SportsObstacle sportsObstacle : sportsObstacles){

                if (sportsObstacle.overcomeObstacle(competitor)){
                    System.out.println(competitor.toString() + " преодолел " + sportsObstacle.toString().toLowerCase());
                } else {
                    System.out.println(competitor.toString() + " не смог преодолеть " + sportsObstacle.toString().toLowerCase());
                    isFinished = false;
                    break;
                }
            }
            if (isFinished) System.out.println(competitor + " финишировал.");
        }
    }
}
