//Aja Curry
//Alex Soyoh

import java.io.*;
import java.util.Scanner;

public class Files {
    public static void main(String [] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        int problem = 0;
        boolean go = true;

        //Game loop
        while (go) {
            System.out.println("Select a problem from 1 to 3, use 0 to quit.");

            //User validation for problem number input
            if (input.hasNextInt()) {
                problem = input.nextInt();
            } else System.exit(0);

            //Game menu
            switch (problem) {
                case 1: Problem1();
                    break;
                case 2: Problem2();
                    break;
                case 3: Problem3();
                    break;
            }
        }
    }

    //Problem 1: Reading Files
    public static void Problem1() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File inFile = new File ("input.txt"); //File object

        double number = 0;
        double sum = 0;
        double count = 0;
        double max = 0;
        double average = 0;

        //Finding max number and average
        while (input.hasNext()) {
            number = input.nextDouble();

            //Calculations
            sum = (number + sum);
            count++;

            //Max number
            if(number >= max) {
                max = number;
            }

            //Average number
            average = (sum / count);
        }

        //Display
        System.out.println("The maximum number is: " + max);
        System.out.println("Average Number: " + average);

        input.close(); //Closes file
    }

    //Problem 2: Student Records
    public static void Problem2() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        PrintStream outputFile = new PrintStream(new File("students.dat")); //Prints data

        String fName = " ";
        String lName = " ";
        String grade = " ";
        String year = " ";
        int count = 0;

        //Student records
        System.out.println("Enter any number of student records: ");

        //User validation for student records
        if (input.hasNextInt()) {
            count = input.nextInt();
        } else System.exit(0);

        //Problem
        for (int i = 1; i <= count; i++) {
            System.out.println("Enter first name: ");

            //User validation for first name
            if (input.hasNextLine()) {
                fName = input.nextLine();
            } else System.exit(0);

            System.out.println("Enter last name: ");

            //User validation for last name
            if (input.hasNextLine()) {
                lName = input.nextLine();
            } else System.exit(0);

            System.out.println("Enter grade letter (A,B,C,D,F): ");

            //User validation for grade letter
            if (input.hasNextLine()) {
                grade = input.nextLine();
            } else System.exit(0);

            System.out.println("Enter school year: ");

            //User validation for school year
            if (input.hasNextLine()) {
                year = input.nextLine();
            } else System.exit(0);

            //Display
            outputFile.println(fName + " " + lName);
            outputFile.println(grade);
            outputFile.println(year);
        }
    }

    //Problem 3: Read from students.dat
    public static void Problem3() throws FileNotFoundException {
        File inFile = new File ("students.dat");
        Scanner input = new Scanner(inFile);
        Scanner numInput = new Scanner (System.in);

        boolean go = true;
        int size = 0;
        int count = 0;
        int record = 0;

        //# of student records
        System.out.println("Enter the number of student records in the previous problem: ");
        count = numInput.nextInt();

        //Student record arrays
        String [] name = new String [count];
        String [] grade = new String [count];
        String [] year = new String [count];

        for (int j = 0; j <= count; j++){
            if (input.hasNext()) {
                name[j] = input.nextLine();
                grade[j] = input.nextLine();
                year[j] = input.nextLine();
            }
        }

        for (int j = 0; j < count; j++) {
            System.out.println((j + 1) + " " + name[j]);
        }

        System.out.println("Select a student record: ");
        record = numInput.nextInt();

        System.out.println("Students full records: ");
        System.out.println(name [record - 1]);
        System.out.println(grade [record - 1]);
        System.out.println(year [record - 1]);
    }
}