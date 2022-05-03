//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class Selection {
    public static void main (String [] args) {
        Scanner input = new Scanner (System.in);

        double studentCredits = 0;
        int studentSemesters = 0;
        double studentGPA = 0;
        int number = 0;

        //Credits
        System.out.println("Enter number of credits: ");

        //User input validation for credits
        if (input.hasNextInt()) {
            studentCredits = input.nextDouble();
        } else 
            System.out.println("Not an integer.");
        System.out.println("You have: " + studentCredits + " credits.");

        //Semester
        System.out.println("Enter the number of semesters: ");

        //User input validation for semester
        if (input.hasNextInt()) {
            studentSemesters = input.nextInt();
        } else
            System.out.println("Not an integer.");
        System.out.println("You took: " + studentSemesters + " semester(s).");

        //GPA
        System.out.println("Enter GPA: ");

        //User input validation for GPA
        if (input.hasNextInt()) {
            studentGPA = input.nextDouble();
        } else
            System.out.println("Not an integer.");
        System.out.println("Your current GPA is: " + studentGPA);

        //College Year
        if (studentCredits <= 30) {
            System.out.println("Freshman");
        } else if (studentCredits <= 60) {
            System.out.println("Sophomore");
        } else if (studentCredits <= 90) {
            System.out.println("Junior");
        } else
            System.out.println("Senior");

        //Type of Student
        if (studentCredits >= 1 && studentCredits <= 5) 
            number = 4; //goes to case 4
        if (studentCredits >= 6 && studentCredits <= 8) 
            number = 3; //goes to case 3
        if (studentCredits >= 9 && studentCredits <= 11) 
            number = 2; //goes to case 2
        if (studentCredits >= 12) 
            number = 1; //goes to case 1
        
        //Menu for types of students
        switch (number) {
            case 1: System.out.println("Full-Time Student");
                break;
            case 2: System.out.println("Three-Quarter Time Student");
                break;
            case 3: System.out.println("Half-Time Student");
                break;
            case 4: System.out.println("Less Than Half-Time Student");
                break;
        
        }

        //Good or Bad Standing
        number = 0; //resets cases
        
        if ((studentGPA >= 0 && studentGPA <= 1.5) && (studentCredits >= 1 && studentCredits <= 29.5))
            number = 1; //goes to case 1
        if ((studentGPA >= 1.75 && studentGPA <= 2.0) && (studentCredits >= 30 && studentCredits <= 59.5))
            number = 1; //goes to case 1
        if ((studentGPA >= 2.0) && (studentCredits >= 60))
            number = 1; //goes to case q
        
        //Menu for Good or Bad Standing
        switch (number) {
            case 1: System.out.println("Good Standing");
                break;
            default: System.out.println("Bad Standing");
        }
    }
}
