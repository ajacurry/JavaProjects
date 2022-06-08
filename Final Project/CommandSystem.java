//Aja Curry
//Stefanos Savvides

import java.util.*;

public class CommandSystem {
    public static int DISPLAY_WIDTH = 80;
    public GameState state;
    public List<String> verbs = new ArrayList<String>();
    public List<String> verbDescription = new ArrayList<String>(); // Verb description
    public List<String> nouns = new ArrayList<String>(); // Nouns
    boolean hidden;
    boolean ate;
    boolean hunted;

    public CommandSystem(GameState state) {

        this.state = state;

        DISPLAY_WIDTH = GameState.DISPLAY_WIDTH;

        hidden = false;
        ate = false;
        hunted = false;

        addVerb("wait", "Use the wait command to stay in your current location.");
        addVerb("hide", "Use the hide command to hide in your current location.");
        addVerb("go", "Use the go command to leave your current location.");
        addVerb("hunt", "Use the hunt command to find food.");
        addVerb("exit", "Use the exit command to leave the cage.");
        addVerb("back", "Use the back command to go back to a location.");
        addVerb("eat", "Use the eat command to eat food.");
        addVerb("help", "Type 'help' to view verb screen.");
        addVerb("quit", "Use the quit command to exit the game.");
    }

    public void executeVerb(String verb) {
        switch (verb) {
            case "help":
                this.printHelp();
                break;

            case "exit":
                if (state.currentLocation.name.equals("Cage")) {
                    System.out.println("You have exited the cage and entered the public grounds of the zoo.\nThere is a lot of people here, it's smart to not be seen right now.\nThere is a dumpster not too far from you.");
                    state.ChangeLocation();
                } else
                    System.out.println("You can't exit at this location.");
                break;

            case "wait":
                if (state.currentLocation.name.equals("Cage")) {
                    System.out.println("You chose to stay and wait in the cage. As time went on, the zookeeper locked the gate.\nYou did not escape the zoo.");
                    System.exit(0);
                } else if (state.currentLocation.name.equals("Highway")) {
                    System.out.println("You choose to stay and wait at the highway.\nYou got hit by a car while waiting.\nYou did not escape the zoo.");
                    System.exit(0);
                } else
                    System.out.println("You were seen by families because you waited! You got caught by animal control and got put back into your cage.\nYou did not escape the zoo.");
                    System.exit(0);
                break;

            case "hide":
                if (state.currentLocation.name.equals("Zoo")) {
                    hidden = true;
                    System.out.println("You choose to hide in the zoo. You find a good hiding spot behind the dumpster. \nThe zoo has closed and you need to go to the city.");
                } else
                    System.out.println("You can't hide in your current location.");
                break;

            case "hunt":
                if (state.currentLocation.name.equals("Zoo")) {
                    System.out.println("You proceeded to hunt. Oops, you attacked a civilian.");
                    System.out.println("You got shot at by law enforcement for attacking a human and died.\nYou did not escape the zoo.");
                    System.exit(0);
                } else if (state.currentLocation.name.equals("City")) {
                    System.out.println("You proceeded to hunt. Oops, you attacked a civilian.");
                    System.out.println("You got captured by Animal Control for attacking a human.\nYou did not escape the zoo.");
                    System.exit(0);
                } else if (state.currentLocation.name.equals("Highway")) {
                    hunted = true;
                    System.out.println("You hunted for food and found rabbit, and deer.");
                    System.out.println("Choose if you want to eat the rabbit or the deer.");
                } else
                    System.out.println("You can't hunt in your current location...");
                break;

            case "go":

                if (state.currentLocation.name.equals("Zoo")) {
                    if (hidden) {
                        System.out.println("You're going to the next location which is the city of Oakland, 30 miles away from the mountain.\nYou leave the zoo premises and make it to the city.\nYou are hungry from hiding in the zoo all night, but you want to get home.\nThe next step is to make it to the highway.");
                        state.GoLocation();
                    } else {
                        System.out.println("You attempted to leave the zoo while there were a lot of people, \nyou got captured and got sent back to your cage.\nYou did not escape the zoo.");
                        System.exit(0);
                    }

                } else if (state.currentLocation.name.equals("City")) {
                    System.out.println("You make it out of the city, and finally reach the highway, 1 mile away from the mountain, however, you're still hungry from the zoo. \nDo you run across the highway to go home or hunt to find food?");
                    state.GoLocation();
                } else if (state.currentLocation.name.equals("Highway")) {
                    if (ate) {
                        System.out.println("You're going to the next location which is the mountain.");
                        state.GoLocation();
                        System.out.println("You've finally escaped the zoo and made it back home.\nYou Win! ");
                        System.exit(0);
                    } else {
                        System.out.println("You attempted to reach the mountain but on your way there you died from hunger.\nYou did not escape the zoo.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Can't do this yet...");
                }
                break;

            case "eat":
                if (state.currentLocation.name.equals("Highway")) {
                    if (hunted == true) {
                        System.out.println("You ate the food, you are not hungry any more.\nOnly one step away from home.");
                        ate = true;
                    } else {
                        System.out.println("Can't eat yet because you haven't hunted for food...");
                    }
                } else {
                    System.out.println("You can't do that here, try something else...");
                }
                break;

            case "back":
                if (state.currentLocation.name.equals("Zoo")) {
                    System.out.println("You choose to go back into the cage with the zookeeper, but the zookeeper closed the cage door.");
                    System.out.println("You're back in your cage.\nYou did not escape the zoo.");
                    System.exit(0);
                } else if (state.currentLocation.name.equals("City")) {
                    System.out.println("You tried to get back into the zoo through the zoo entrance and got caught.\nYou did not escape the zoo.");
                    System.exit(0);
                } else if (state.currentLocation.name.equals("Highway")) {
                    System.out.println("You are back in the city. There is a lot of people here, it's best to leave this place to stay safe. ");
                    state.BackLocation();
                } else {
                    System.out.println("You can't do this command...");
                }
                break;

            case "quit":
                System.out.println("You've exited the game.");
                System.exit(0);
                break;
        }
    }

    public void executeVerbNoun(String verb, String noun) {
        String resultString = "";

        switch (verb) { // Nouns decide what to do based on the verbs
            case "exit":
                switch (noun) { // For the given verb, this decides what to do based on what noun was entered
                    case "cage":
                        if (state.currentLocation.name.equalsIgnoreCase("cage")) {
                            resultString += "You have exited the cage and entered the public grounds of the zoo.\nThere is a lot of people here, it's smart to not be seen right now. \nThere is a dumpster not too far from you.";
                            state.ChangeLocation();
                        } else {
                            resultString += "You're not in a cage.";
                        }
                        break;
                }
                break;

            case "wait":
                switch (noun) {
                    case "cage":
                        if (state.currentLocation.name.equals("Cage")) {
                            System.out.println("You chose to stay and wait in the cage. As time went on, the zookeeper locked the gate.\nYou did not escape the zoo.");
                            System.exit(0);
                        } else {
                            System.out.println("You're not in a cage...");
                        }
                        break;

                    case "zoo":
                        if (state.currentLocation.name.equals("Zoo")) {
                            System.out.println("You were caught standing in the zoo by zookeepers and guests and put back in your cage.\nYou did not escape the zoo.");
                            System.exit(0);
                        } else {
                            System.out.println("You're not in the zoo...");
                        }
                        break;

                    case "city":
                        if (state.currentLocation.name.equals("City")) {
                            System.out.println("You were caught waiting in the city by animal control and got put back in your cage.\nYou did not escape the zoo.");
                            System.exit(0);
                        } else {
                            System.out.println("You're not in the city...");
                        }
                        break;

                    case "highway":
                        if (state.currentLocation.name.equals("Highway")) {
                            System.out.println("You choose to stay and wait at the highway.\nYou got hit by a car while waiting.\nYou did not escape the zoo.");
                            System.exit(0);
                        } else {
                            System.out.println("You're not at the highway...");
                        }
                        break;
                }
                break;

            case "hide":
                switch (noun) {
                    case "dumpster":
                        hidden = true;
                        if (state.currentLocation.name.equals("Zoo")) {
                            resultString += "You choose to hide in the zoo. You find a good hiding spot behind the dumpster. \n The zoo has closed and you need to go to the city. ";
                        } else {
                            System.out.println("Can't do that here...");
                        }

                        break;
                }
                break;

            case "go":
                switch (noun) {
                    case "city":
                        if (state.currentLocation.name.equals("Zoo")) {
                            if (hidden) {
                                resultString += "You're going to the next location which is the city of Oakland, 30 miles away from the mountain. \nYou leave the zoo premises and make it to the city.\nYou are hungry from hiding in the zoo all night, but you want to get home.\nThe next step is to make it to the highway.";
                                state.GoLocation();
                            } else {
                                System.out.println("You attempted to leave the zoo while there was a lot of people, \nyou got captured and got sent back to your cage.\nYou did not escape the zoo.");
                                System.exit(0);
                            }
                        } else {
                            System.out.println("Can't do that yet...");
                        }
                        break;

                    case "highway":
                        if (state.currentLocation.name.equals("City")) {
                            System.out.println("You make it out of the city, and finally reach the highway, 1 mile away from the mountain, however, you're still hungry from the zoo. \nDo you run across the highway to go home or hunt to find food?");
                            state.GoLocation();
                        } else {
                            System.out.println("Can't do that yet...");
                        }
                        break;

                    case "mountain":
                        if (state.currentLocation.name.equals("Highway")) {
                            if (ate) {
                                System.out.println("You've finally escaped the zoo and made it back home.\nYou Win! ");
                                System.exit(0);
                            } else {
                                System.out.println("You attempted to reach the mountain but on your way there you died from hunger.\nYou did not escape the zoo.");
                                System.exit(0);
                            }
                        } else {
                            System.out.println("Can't do that yet...");
                        }
                        break;
                }
                break;

            case "hunt":
                switch (noun) {
                    case "food":
                        if (state.currentLocation.name.equals("Zoo")) {
                            System.out.println("You proceeded to hunt. Oops, you attacked a civilian.");
                            System.out.println("You got shot at by law enforcement for attacking a human and died.\nYou did not escape the zoo.");
                            System.exit(0);
                        } else if (state.currentLocation.name.equals("City")) {
                            System.out.println("You proceeded to hunt. Oops, you attacked a civilian.");
                            System.out.println("You got shot at by law enforcement for attacking a human and died.\nYou did not escape the zoo.");
                            System.exit(0);
                        } else if (state.currentLocation.name.equals("Highway")) {
                            hunted = true;
                            System.out.println("You hunted for food and found rabbit, and deer.");
                            System.out.println("Choose if you want to eat the rabbit or the deer.");
                        } else {
                            System.out.println("You can't hunt in your current location...");
                        }
                        break;
                }
                break;

            case "eat":
                switch (noun) {
                    case "food":
                        if (state.currentLocation.name.equals("Highway")) {
                            if (hunted == true) {
                                System.out.println("You ate the food, you are not hungry any more.\nOnly one step away from home.");
                                ate = true;
                            } else {
                                System.out.println("Can't eat yet because you haven't hunted for food...");
                            }
                        } else {
                            System.out.println("You can't do that here, try something else...");
                        }
                        break;

                    case "meat":
                        if (state.currentLocation.name.equals("Highway")) {
                            if (hunted == true) {
                                System.out.println("You ate the meat, you are not hungry any more.\nOnly one step away from home.");
                                ate = true;
                            } else {
                                System.out.println("Can't eat yet because you haven't hunted for food...");
                            }
                        } else {
                            System.out.println("You can't do that here, try something else...");
                        }
                        break;

                    case "rabbit":
                        if (state.currentLocation.name.equals("Highway")) {
                            if (hunted == true) {
                                System.out.println("You ate the rabbit meat, you are not hungry any more.\nOnly one step away from home.");
                                ate = true;
                            } else {
                                System.out.println("Can't eat yet because you haven't hunted for food...");
                            }
                        } else {
                            System.out.println("You can't do that here, try something else...");
                        }
                        break;

                    case "deer":
                        if (state.currentLocation.name.equals("Highway")) {
                            if (hunted == true) {
                                System.out.println("You ate the deer meat, you are not hungry any more.\nOnly one step away from home.");
                                ate = true;
                            } else {
                                System.out.println("Can't eat yet because you haven't hunted for food...");
                            }
                        } else {
                            System.out.println("You can't do that here, try something else...");
                        }
                        break;
                }
                break;

            case "back":
                switch (noun) {
                    case "cage":
                        if (state.currentLocation.name.equals("Zoo")) {
                            System.out.println("You went back into the cage with the zookeeper and the zookeeper closed the cage door. You did not escape the zoo.");
                            System.exit(0);
                        } else {
                            System.out.println("Can't do that yet...");
                        }
                        break;

                    case "zoo":
                        if (state.currentLocation.name.equals("City")) {
                            System.out.println("You tried to get back into the zoo through the zoo entrance and got caught.\nYou did not escape the zoo.");
                            System.exit(0);
                        } else {
                            System.out.println("Can't do that yet...");
                        }
                        break;

                    case "city":
                        if (state.currentLocation.name.equals("Highway")) {
                            System.out.println("You are back in the city. There is a lot of people here, it's best to leave this place to stay safe.");
                            state.BackLocation();
                        } else {
                            System.out.println("Can't do that yet...");
                        }
                        break;

                    default:
                        resultString += "Invalid input...";
                }

        }
        System.out.println(formatStringToScreenWidth(resultString));
    }

    public void executeVerbNounNoun(String verb, String noun1, String noun2) {
        switch (verb) {
            case "eat":
                switch (noun1) {
                    case "rabbit":

                        switch (noun2) {
                            case "meat":
                                if (state.currentLocation.name.equals("Highway")) {
                                    if (hunted == true) {
                                        System.out.println("You ate the rabbit meat, you are not hungry any more.\nOnly one step away from home.");
                                        ate = true;

                                    } else {
                                        System.out.println("Can't eat yet because you haven't hunted for food...");
                                    }
                                } else {
                                    System.out.println("You can't do that here, try something else...");
                                }
                                break;
                        }
                        break;

                    case "deer":
                        switch (noun2) {
                            case "meat":
                                if (state.currentLocation.name.equals("Highway")) {
                                    if (hunted == true) {
                                        System.out.println("You ate the deer meat, you are not hungry any more.\nOnly one step away from home.");
                                        ate = true;
                                    } else {
                                        System.out.println("Can't eat yet because you haven't hunted for food...");
                                    }
                                } else {
                                    System.out.println("You can't do that here, try something else...");
                                }
                                break;
                        }
                        break;

                }
                break;
        }

    }

    // Prints the help menu going through all the verbs and verb descriptions
    // Prints the list of commands the user can use
    public void printHelp() {
        System.out.println("'wait', Use the wait command to stay in your current location.");
        System.out.println("'hide', Use the hide command to hide in your current location.");
        System.out.println("'go'  , Use the go command to leave your current location.");
        System.out.println("'hunt', Use the hunt command to find food.");
        System.out.println("'exit', Use the exit command to leave the cage.");
        System.out.println("'eat', Use the eat command to eat your food.");
        System.out.println("'back', Use the back command to go back to a location.");
        System.out.println("'quit', Use the quit command to exit the game.");
    }

    // Allows the client code to see if a verb is in the game
    public boolean hasVerb(String string) {
        return verbs.contains(string);
    }

    // Allows the client code to see if a noun is in the game
    public boolean hasNoun(String string) {
        return nouns.contains(string);
    }

    // (help menu) format
    public String formatMenuString(String longString) {
        String result = "";
        Scanner chop = new Scanner(longString);
        int charLength = 0;

        while (chop.hasNext()) {
            String next = chop.next();
            charLength += next.length();
            result += next + " ";
            if (charLength >= (DISPLAY_WIDTH - 30)) {
                result += "\n          ";
                charLength = 0;
            }
        }
        chop.close();
        return result + "\n\n";
    }

    // Formats a string to DISPLAY_WIDTH character width.
    // Used when getting descriptions from items/locations and printing them to the
    // screen.
    // use [nl] for a newline in a string in a description etc.
    public String formatStringToScreenWidth(String longString) {

        Scanner chop = new Scanner(longString);
        String result = "";
        int charLength = 0;
        boolean addSpace = true;

        while (chop.hasNext()) {

            // Get our next word in the string.
            String next = chop.next();

            // Add the length to our charLength.
            charLength += next.length() + 1;

            // Find and replace any special newline characters [nl] with \n.
            if (next.contains("[nl]")) {
                // Find the index after our [nl] characters.
                int secondHalf = next.indexOf("[nl]") + 4;

                // Set charLength to the number of characters after the [nl],
                // because that will be the beginnig of a new line.
                if (secondHalf < next.length()) {
                    charLength = secondHalf;
                } else {
                    charLength = 0;
                    addSpace = false; // Do not add space after if this ended with a newline character.
                }

                // Now actually replace the [nl] with the newline character
                next = next.replace("[nl]", "\n");

            }

            // Add the word to the result.
            result += next;

            // Only add a space if our special case did not happen.
            if (addSpace)
                result += " ";

            // Normally we add a space after a word, prepare for that.
            addSpace = true;

            if (charLength >= DISPLAY_WIDTH) {
                result += "\n";
                charLength = 0;
            }
        }
        chop.close();
        return result;
    }

    public void addNoun(String string) {
        if (!nouns.contains(string.toLowerCase()))
            nouns.add(string.toLowerCase());
    }

    public void addVerb(String verb, String description) {
        verbs.add(verb.toLowerCase());
        verbDescription.add(description.toLowerCase());
    }

}
