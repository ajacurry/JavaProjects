//Aja Curry
//Alex Soyoh

import java.util.Scanner;
import java.io.*;

public class Creature {

    //Fields for creature
    private String name;
    private String description;
    private int endurance;
    private String filename;
    private String phrase [] = new String [] {"roar","ruff","bark"};
    private int index = 0;

    //Constructor with no parameter
    public Creature() {
        Scanner input = new Scanner (System.in);

        System.out.println("Enter the creatures name: ");
        name = input.nextLine();

        System.out.println("Enter the description of the creature: ");
        description = input.nextLine();

        System.out.println("Enter the endurance of the creature: ");
        endurance = input.nextInt();

        input.nextLine(); //Skips the next line

        System.out.println("Enter the filename: ");
        filename = input.nextLine();
        index = 0;
    }

    //Saves creature data
    public void write() throws FileNotFoundException {
        PrintStream outFile = new PrintStream(new File(filename));

        outFile.println(name);
        outFile.println(description);
        outFile.println(endurance);
    }

    //Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEndurance() {
        return endurance;
    }

    //Endurance
    public void setEndurance(int endurance) {
        if(endurance < 0) {
            this.endurance = 0;
        }else if (endurance == 0) {
            System.out.println("TIRED");
        }else if (endurance > 0) {
            System.out.println(name + " feels better.");
        }
    }

    //If the creature is sleep
    public boolean knockedOut() {
        if(endurance == 0) {
            return false;
        }else return true;
    }

    //Creatures phrases
    public String phrases() {
        if(index >= 3) {
            index = 0;
        }

        return phrase[index++];
    }

    //Creatures new phrases
    public void newphrases(String newString) {
        if(index >= 3) {
            index = 0;
        }

        phrase[index] = newString;
    }

    //Write data to a file
    public void save(String filename) throws FileNotFoundException {
        System.out.println("Feels better.");

        write();
    }

    //Display
    public String toString() {
        return name + " " + description + " and the endurance is: " + endurance;
    }

    //Growled
    public String growled() {
        return "You pet the creature and it growled.";
    }

    //Reads the file
    public void read() throws FileNotFoundException {
        File infile = new File(filename);
        Scanner input = new Scanner (infile);

        while(input.hasNext()) {
            setName(input.nextLine());
            setDescription(input.nextLine());
            setEndurance(input.nextInt());
        }
    }
}