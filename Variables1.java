//Aja Curry
//Alex Soyoh

import java.util.Scanner;

public class Variables1 {
    public static void main (String [] args) {
        Scanner input = new Scanner (System.in);

        double itemPrice;
        double salesTax;
        double totalPrice;

        System.out.println("Enter the price of the item: ");
        itemPrice = input.nextDouble();

        System.out.println("Enter the sales tax rate: ");
        salesTax = input.nextDouble() / 100;

        totalPrice = itemPrice + (itemPrice * salesTax);
        System.out.println("Total Price: " + totalPrice);
    }
}