//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class TicTacToe {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);

        //Tic-Tac-Toe Board
        String[] row1 = new String[] {" _ "," _ "," _ "};
        String[] row2 = new String[] {" _ "," _ "," _ "};
        String[] row3 = new String[] {" _ "," _ "," _ "};
        
        //Variables
        int row = 0;
        int column = 0;

        //Displays Board
        System.out.println(row1[0] + row1[1] + row1[2]);
        System.out.println(row2[0] + row2[1] + row2[2]);
        System.out.println(row3[0] + row3[1] + row3[2]);

        //Row
        System.out.println("Select a row: ");
        
        //User input validation for row
        if (input.hasNextInt()) {
            row = input.nextInt();
        }else System.exit(0);

        //Out of bounds
        if (row > 3 || row < 0) {
            System.out.println("Not a row.");
            System.exit(0);
        }

        //Column
        System.out.println("Select a column: ");

        //User input validation for column
        if (input.hasNextInt()) {
            column = input.nextInt();
        }else System.exit(0);

        if (row > 3 || row < 0) {
            System.out.println("Not a column.");
            System.exit(0);
        }

        //Menu for board
        switch (row) {
            case 1: row1[column - 1] = " X ";
                break;
            case 2: row2[column - 1] = " X ";
                break;
            case 3: row3[column - 1] = " X ";
                break;
        }

        //Displays new board
        System.out.println(row1[0] + row1[1] + row1[2]);
        System.out.println(row2[0] + row2[1] + row2[2]);
        System.out.println(row3[0] + row3[1] + row3[2]);
    }  
}