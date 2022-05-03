//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class Variables4 {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);

        double testScore1;
        double testScore2;
        double testScore3;
        double averageScore;

        System.out.println("Enter score 1: ");
        testScore1 = input.nextDouble();

        System.out.println("Enter score 2: ");
        testScore2 = input.nextDouble();

        System.out.println("Enter score 3: ");
        testScore3 = input.nextDouble();

        averageScore = (testScore1 + testScore2 + testScore3) / 3;
        System.out.println("Average Score: " + averageScore);
    }
}