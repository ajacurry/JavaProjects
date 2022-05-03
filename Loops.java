//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class Loops{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int problem = 0;
        int choice = 0;
        boolean go = true;

        //Game loop
        while (go) {
            System.out.println("Select a problem from 1 to 4, use 0 to quit.");

            //User validation for problem number input
            if (input.hasNextInt()) {
                problem = input.nextInt();
            } else System.exit(0);

            //Game menu
            switch (problem) {
                case 0: go = false;
                    break;
                case 1: Problem1();
                    break;
                case 2: Problem2();
                    break;
                case 3: Problem3();
                    break;
                case 4: Problem4();
                    break;
            }
        }
    }

    //Problem1: Temperature
    public static void Problem1() {
        Scanner input = new Scanner(System.in);
        
        double temp = 0;
        double avg = 0;
        int above = 0;
        int below = 0;
        int choice = 0;
        double count = 1;
        double total = 0;
        boolean go = true;

        //Temperature Loop
        while (go) {
            System.out.println("Enter a temperature: ");

            //User validation for temperature loop
            if (input.hasNextDouble()) {
                temp = input.nextDouble();
            } else System.exit(0);

        //Calculations
        total = (total + temp);
        avg = (total / count);

        //Above or Below Freezing
        if (temp <= 32) {
            above++;
        }else {
            below++;
        } count++;

        System.out.println("Average temperature: " + avg);
        System.out.println("Would you like to enter another temperature? ");
        System.out.println("Enter '1' for yes or '2' for no.");
        
        //User validation for choice
        if (input.hasNextInt()) {
            choice = input.nextInt();
        } else System.exit(0);

        //Ends game
        if (choice == 2) {
            go = false;
        }

        //Displays average temperature and above or below freezing
        System.out.println("Average: " + avg);
        System.out.println("Above Freezing: " + above);
        System.out.println("Below Freezing: " + below);

        }
    }

    //Problem 2: Test Scores
    public static void Problem2() {
        Scanner input = new Scanner(System.in);

        double testScores = 0;
        double A = 0;
        double B = 0;
        double C = 0;
        double D = 0;
        double F = 0;
        double total = 0;
        double count = 1;
        double avg = 0;
        int choice = 0;
        boolean go = true;

        //Test Scores Loop
        while (go) {
            System.out.println("Enter a test score: ");

            //User validation for test scores loop
            if (input.hasNextDouble()) {
                testScores = input.nextDouble();
            } else System.exit(0);
    
            //Calulations
            total = total + testScores;
            avg = (total / count);
            System.out.println("Average temperature: " + avg);
    
            //Grade
            if (testScores >= 90)
                A++;
            else if (testScores >= 80)
                B++;
            else if (testScores >= 70)
                C++;
            else if (testScores >= 60)
                D++;
            else 
                F++;
            count++;
    
            System.out.println("Would you like to enter another test score? ");
            System.out.println("Enter '1' for yes or '2' for no.");
    
            //User validation for choice
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else System.exit(0);
    
            //Ends game
            if (choice == 2) {
                go = false;
            }
    
            //Displays number og graades
            System.out.println("There is (are): ");
            System.out.println("A: " + A);
            System.out.println("B: " + B);
            System.out.println("C: " + C);
            System.out.println("D: " + D);
            System.out.println("F: " + F); 
        }
    }

    //Problem 3: Types of Loops
    public static void Problem3() {
        Scanner input = new Scanner(System.in);

        int count = 1;

        //Print 1-10
        System.out.println("Part A");

        do {
            System.out.println("Print: " + count);
            count++;
        } while (count <= 10);

        //Print 10-1
        System.out.println("Part B");

        count = 10; //resets count

        for (int i = 1; i <= 10; i++) {
            System.out.println("Print: " + count);
            count--;
        }

        //Print 2-20 (Evens Only)
        System.out.println("Part C");

        for (int i = 1; i <= 20; i++) {
            count++;
        
        //Evens Only
        if (count %2 == 0) {
            System.out.println("Print: " + count);
        }
        }

        //Repeating this section
        System.out.println("Part D");

        //Resetting variables
        int choice = 0;
        count = 0;
        boolean go = true;

        //To repeat
        while (go) {
            System.out.println("Hello, would you like to repeat this section?: ");
            System.out.println("Enter '1' for yes or '2' for no.");

            //User validation for repeat
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else System.exit(0);

            //Ends game
            if (choice == 2) {
                go = false;
                System.out.println("Number of repetitions: " + count);
            }
        
            count++;
        }

        //Uppercase Letters
        System.out.println("Part E");
        System.out.println("List of letters in uppercase, in this loops: ");

        //Format for alphabet
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.printf("%s ", ch);
        }

        //I Love Java
        System.out.println("\nPart F");
        System.out.println("Enter a number: ");

        //User validation for I Love Java
        if (input.hasNextInt()) {
            choice = input.nextInt();
        } else System.exit(0);

        //Number of times printing "I Love Java"
        for (int i = 1; i <= choice; i++) {
            System.out.println("I Love Java");
        }
    }

    //Problem 4: Destinations
    public static void Problem4() {
        Scanner input = new Scanner(System.in);

        int min = 1;
        int max = 5;
        String [] location = new String [5];

        //Game
        System.out.println("Choose 5 destinations: ");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Destination: " + i); 
            location[i-1] = input.nextLine();
        }

        //Random Destination
        for (int i = 1; i <= 3; i++) {
            int randomInt = (int) Math.floor(Math.random() * (max-min + 1) + min);
            System.out.println("Random Number: " + randomInt);
            System.out.println(location[randomInt - 1]);
        }
    }
}