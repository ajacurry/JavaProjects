//Aja Curry
//Alex Soyoh

import java.util.Scanner;
import java.io.*;

public class Objects {
    public static void main(String [] args) throws FileNotFoundException {
        Scanner input = new Scanner (System.in);

        //Creating a creature
        Creature c = new Creature();
        String newPhrase = " ";

        //Printing
        System.out.println(c.getName());
        System.out.println(c.getDescription());
        System.out.println(c.getEndurance());

        //Phrases
        System.out.println(c.phrases());
        System.out.println(c.phrases());
        System.out.println(c.phrases());

        //New phrases
        System.out.println("Enter a new phrase: ");
        newPhrase = input.nextLine();
        c.newphrases(newPhrase);

        System.out.println(c.phrases());
        System.out.println(c.phrases());
        System.out.println(c.phrases());
        System.out.println(c.phrases());

        //Endurance until tired
        int e = c.getEndurance();

        while(e != 0) {
            e--;
        }

        System.out.println(c.growled());

        //New creature name
        String newName = " ";
        System.out.println("Enter creatures new name: ");
        newName = input.nextLine();
        c.setName(newName);

        c.write();

        c.read();

        System.out.println(c.toString());
    }
}