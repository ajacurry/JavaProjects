//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class Variables5 {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);

        int number1;
        int number2;
        int result;

        System.out.println("Enter number 1: ");
        number1 = input.nextInt();

        System.out.println("Enter number 2: ");
        number2 = input.nextInt();

        result = (number1 + number2);
        System.out.println("Sum: " + result);

        result = (number1 - number2);
        System.out.println("Difference: " + result);

        result = (number1 * number2);
        System.out.println("Product: " + result);

        result = (number1 / number2);
        System.out.println("Remainder: " + result);

        result = (number1 % number2);
        System.out.println("Modulo: " + result);
    }
}