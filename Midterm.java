//Aja Curry

import java.util.Scanner;

public class Midterm {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        int language = 0;
        boolean go = true;

        while (go) {
            System.out.println("______________________________________");
            System.out.println("Select a language, use 4 to quit.");
            System.out.println("Select '1' for English.");
            System.out.println("Select '2' for French.");
            System.out.println("Select '3' for Spanish.");
            System.out.println("Select '4' to Quit.");
            System.out.println("______________________________________");

            //User validation for problem number input
            if (input.hasNextInt()) {
                language = input.nextInt();
            } else System.exit(0);

            switch (language) {
                case 1: English();
                    break;
                case 2: French();
                    break;
                case 3: Spanish();
                    break;
                case 4: Exit();
                    break;
            }
        }
    }

    //English
    public static void English() {
        System.out.println("Hello.");
    }

    //French
    public static void French() {
        System.out.println("Bonjour.");
    }

    //Spanish
    public static void Spanish() {
        System.out.println("Hola.");
    }

    //Exit
    public static void Exit() {
        System.out.println();
    }
}