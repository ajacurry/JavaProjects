//Aja Curry
//Stefanos Savvides

import java.util.*;

public class App {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        GameState state = new GameState(); //Holds objects

        CommandSystem commandSystem = state.commandSystem; //Holds commands

        boolean condition = true;

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("You are a mountain lion who is planning to escape from the Oakland Zoo in Oakland, California, \nand a distraced zookeeper leaves the gate open, bringing an opportunity for you to escape.");
        System.out.println("You're trying to make it back to your natural habitat 50 miles outside the city, without getting caught or killed.");
        System.out.println("First step is escaping from the zoo, try and find the opportunity to leave...");

        while (condition) {
            String[] input = getCommand();

            if (input.length < 1) {
                System.out.println("Unknown command. Type \"Help\" for help.");

            } else if (input[0].equals("quit")) {
                condition = false;
                System.out.println("Goodbye.");
                in.close();

                // Command has 1 word - Check if it is a valid verb and execute it.
            } else if (input.length == 1 && commandSystem.hasVerb(input[0])) {
                commandSystem.executeVerb(input[0]);

                // Command has 2 words - should be verb and noun.
            } else if (input.length == 2) {
                // Validate that the commands are known verb/nouns
                if (!commandSystem.hasVerb(input[0])) {
                    unknownCommand(input[0]);
                } else if (!commandSystem.hasNoun(input[1])) {
                    unknownCommand(input[1]);
                } else {
                    // Run command
                    commandSystem.executeVerbNoun(input[0], input[1]);
                }

                // command has 3 words - should be verb noun noun
            } else if (input.length == 3) {
                // Validate that the commands are known verb/nouns
                if (!commandSystem.hasVerb(input[0])) {
                    unknownCommand(input[0]);
                } else if (!commandSystem.hasNoun(input[1])) {
                    unknownCommand(input[1]);
                } else if (!commandSystem.hasNoun(input[2])) {
                    unknownCommand(input[2]);
                } else {
                    // Run command
                    commandSystem.executeVerbNounNoun(input[0], input[1], input[2]);
                }

                // Deal with any possible unknown structure/command
            } else {
                if (input.length > 1) {
                    String userInput = "";

                    for (String s : input)
                        userInput += s + " ";

                    unknownCommand(userInput);

                } else {
                    unknownCommand(input[0]);
                }
            }
        }

    }

    // Gets input from the user
    // seperates the input into each word (determined by whitespace)
    // returns an array with each word an element of the array.
    public static String[] getCommand() {

        in = new Scanner(System.in);

        // System.out.println(commandSystem.verbs);
        System.out.println("\nWhat do you choose to do now?");
        System.out.println("[wait, hide, go, hunt, exit, eat, back, help, quit]");
        System.out.println("________________________________");
        String input = in.nextLine();
        System.out.println();
        return input.toLowerCase().split("\\s+");
    }

    public static void unknownCommand(String input) {
        if (Math.random() < .3)
            System.out.println("'" + input + "' is not a command! Type 'help' if you need help.");
        else
            System.out.println("I don't understand '" + input + "'. Type 'help' if you need help.");
    }

}
