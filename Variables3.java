//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class Variables3 {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);

        double itemPrice1;
        double itemPrice2;
        double itemPrice3;
        double itemPrice4;
        double itemPrice5;
        double salesTax = .06;
        double totalPrice;
        double finalPrice;

        System.out.println("Enter the price of item 1: ");
        itemPrice1 = input.nextDouble();

        System.out.println("Enter the price of item 2: ");
        itemPrice2 = input.nextDouble();

        System.out.println("Enter the price of item 3: ");
        itemPrice3 = input.nextDouble();

        System.out.println("Enter the price of item 4: ");
        itemPrice4 = input.nextDouble();

        System.out.println("Enter the price of item 5: ");
        itemPrice5 = input.nextDouble();

        totalPrice = (itemPrice1 + itemPrice2 + itemPrice3 + itemPrice4 + itemPrice5);
        System.out.println("Subtotal: " + totalPrice);
        System.out.println(" Final Total: " + (totalPrice + salesTax));
    }
}