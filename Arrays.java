//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class Arrays {
    public static void main (String [] args) {
        Scanner input = new Scanner (System.in);

        int index = 0;
        int count = 0;

        //Student Records
        System.out.println("How many student records would you like to enter? (Max. is 5): ");

        //User input validation for student records
        if (input.hasNextInt() != true) {
            System.out.println("Invalid input");
        }

        count =input.nextInt();
        input.nextLine(); //Skips the next line

        if(count > 5 || count < 1) {
            System.out.println("Invalid input");
        }

        //Arrays for student data
        String [] names = new String [count];
        String [] grades = new String [count];

        for (int i = 1; i <= count; i++) {
            System.out.println("Enter the name of the entry: ");
            names [index] = input.nextLine();

            System.out.println("Enter grade: ");
            grades [index] = input.nextLine();

            //User input validation for grades
            if (grades[index].length() != 1) {
                 System.out.println("Invalid Input");
            }

            index++;
        }

        index = 0; //resets index

        for (int i = 1; i <= count; i++) {
            System.out.printf("Name: " + names[index] + " Grade: " + grades[index] + "     ");
            //index++;
        }
    }
}