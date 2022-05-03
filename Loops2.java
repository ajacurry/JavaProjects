//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class Loops2 {
    public static void main(String [] args) {
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
                case 0: go = false;
                    break;
                case 1: Problem1();
                    break;
                case 2: Problem2();
                    break;
                case 3: Problem3();
                    break;
            }
        }
    }

    //Problem 1: Calculator
    public static void Problem1() {
        Scanner input = new Scanner(System.in);

        double num1 = 0;
        double num2 = 0;
        char operator = ' ';
        double total;

        //Enter a number
        System.out.println("This program performs arithmetic calculations. ");
        System.out.println("Enter a number: ");

        //User validation for enter a number
        if (input.hasNextDouble()) {
            num1 = input.nextDouble();
        } else System.exit(0);

        //Enter an operator
        System.out.println("Enter an operator: ");

        //User validation for enter an operator
        if (input.hasNextLine()) {
            operator = input.next().charAt(0);
        } else System.exit(0);

        //Enter another number
        System.out.println("Enter another number: ");

        //User validation for entering another number
        if (input.hasNextDouble()) {
            num2 = input.nextDouble();
        } else System.exit(0);

        //Calculations
        switch (operator) {
            case '+':
                total = (num1 + num2);
                System.out.println("Sum: " + total);
                break;
            case '-':
                total = (num1 - num2);
                System.out.println("Difference: " + total);
                break;
            case '*':
                total = (num1 * num2);
                System.out.println("Product: " + total);
                break;
            case '/':
                total = (num1 / num2);
                System.out.println("Quotient: " + total);
                break;
        }
    }

    //Problem 2: Nested For Loop
    public static void Problem2() {
        for(int i = 0; i <= 4; i++) {
            System.out.println();

            for (int j = 0; j <= 4; j++) {
                System.out.print(((j + 1) + (i)));
            }
        }
    }

    //Problem 3: Board Game
    public static void Problem3() {
        Scanner input = new Scanner(System.in);

        char direction = ' ';
        int spaces = 0;
        boolean go = true;
        int choice = 0;
        int row = 4;
        int column = 4;
        String [][] board = new String [][] {
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " },
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " },
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " },
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " },
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " },
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " },
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " },
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " },
        {" _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ "," _ " }
        };

        board[row][column] = " X ";

        for (int i = 0; i <= board.length - 1; i++) {
            System.out.println();
            for (int j = 0; j <= board[i].length - 1; j++) {
                System.out.print(board[i][j]);
            }
        }

        //Board Game
        while (go) {
            System.out.println();
            System.out.println("Choose a direction (N,S,E,W): ");

            //User validation for board game
            if (input.hasNextLine()) {
                direction = input.next().charAt(0);
            } else System.exit(0);

            System.out.println("Enter the number of space: ");

            //User validation for enter a number
            if (input.hasNextInt()) {
                spaces = input.nextInt();
            } else System.exit(0);

            board[row][column] = " _ ";

            //Game Directions
            switch (direction) {
                case 'N': 
                    if (row - spaces < 0) {
                        board[(row - spaces) + 9][column] = " X ";
                        row = (row - spaces) + 9;
                    }else {
                        board[row - spaces][column] = " X ";
                        row = (row - spaces);
                    }
                break;
                case 'S': 
                    if (row - spaces < 0) {
                        board[(row + spaces) - 9][column] = " X ";
                        row = (row + spaces) - 9;
                    }else {
                        board[row + spaces][column] = " X ";
                        row = (row + spaces);
                    }
                break;
                case 'E': 
                    if (column - spaces < 0) {
                        board[row][(column + spaces) - 9] = " X ";
                        column = (column - spaces) - 9;
                    }else {
                        board[row][column + spaces] = " X ";
                        column = (column - spaces);
                    }
                break;
                case 'W': 
                    if (column - spaces < 0) {
                        board[row][(column - spaces) + 9] = " X ";
                        column = (column - spaces) + 9;
                    }else {
                        board[row][column - spaces] = " X ";
                        column = (column - spaces);
                    }
                break;
            }

            for(int i = 0; i <= board.length -1; i++) {
                System.out.println();
                for (int j = 0; j <= board[i].length - 1; j++) {
                    System.out.print(board[i][j]);
                }
            }

            System.out.println();
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
        }

    }
}