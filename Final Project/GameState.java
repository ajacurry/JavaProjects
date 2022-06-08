//Aja Curry
//Stefanos Savvides

public class GameState {

    public static int DISPLAY_WIDTH = 80;
    public CommandSystem commandSystem;
    Location currentLocation;
    Location cage;
    Location zoo;
    Location city;
    Location highway;
    Location mountain;

    public GameState() {

        commandSystem = new CommandSystem(this);

        cage = new Location();
        cage.name = "Cage";
        cage.description = "You are in a cage inside the Oakland Zoo.";
        commandSystem.addNoun(cage.name);

        currentLocation = cage;

        Person zooKeeper = new Person();
        zooKeeper.name = "Zoo Keeper"; // this is for cage
        zooKeeper.description = "A distracted zoo keeper.";

        cage.people[0] = zooKeeper;
        commandSystem.addNoun(zooKeeper.name);

        Item food1 = new Item();
        food1.name = "Food"; // this is for cage
        food1.description = "There is food prepared by the zoo keeper here.";

        cage.items[0] = food1;
        commandSystem.addNoun(food1.name);

        zoo = new Location();
        zoo.name = "Zoo";
        zoo.description = "You are in the zoo, outside of your cage.";
        commandSystem.addNoun(zoo.name);

        Item dumpster = new Item();
        dumpster.name = "Dumpster"; // this is for zoo
        dumpster.description = "There is a dumpster in the zoo that you can hide behind.";

        zoo.items[0] = dumpster;
        commandSystem.addNoun(dumpster.name);

        city = new Location();
        city.name = "City";
        city.description = "You left the zoo, you are now in the city of Oakland.";
        commandSystem.addNoun(city.name);

        Person animalControl = new Person();
        animalControl.name = "AnimalControl"; // this is for city
        animalControl.description = "Animal Control worker who can capture you.";

        city.people[0] = animalControl;
        commandSystem.addNoun(animalControl.name);

        Person civilian = new Person();
        civilian.name = "Civilian";
        civilian.description = "City Civilian";

        city.people[1] = civilian;
        commandSystem.addNoun(civilian.name);

        highway = new Location();
        highway.name = "Highway";
        highway.description = "You've left the city and now you are on the highway leading out of Oakland.";
        commandSystem.addNoun(highway.name);

        Item food2 = new Item();
        food2.name = "Food"; // this is for highway
        food2.description = "There is plenty of food here. Rabbits and deer are easy to find.";

        highway.items[0] = food2;
        commandSystem.addNoun(food2.name);

        Item rabbit = new Item();
        rabbit.name = "Rabbit";
        rabbit.description = "Rabbit meat is found by the highway";

        highway.items[1] = rabbit;
        commandSystem.addNoun(rabbit.name);

        Item deer = new Item();
        deer.name = "Deer";
        deer.description = "Deer meat is found by the highway";

        highway.items[2] = deer;
        commandSystem.addNoun(deer.name);

        Item meat = new Item();
        meat.name = "Meat";
        meat.description = "Unspecidifed meat found by the highway.";

        highway.items[3] = meat;
        commandSystem.addNoun(meat.name);

        mountain = new Location();
        mountain.name = "Mountain";
        mountain.description = "You've left the city and now you are on the highway leading out of Oakland.";
        commandSystem.addNoun(mountain.name);

    }

    public void ChangeLocation() {

        if (currentLocation == cage) {
            currentLocation = zoo;
        }

    }

    public void GoLocation() {

        if (currentLocation == zoo) {
            currentLocation = city;
        }

        else if (currentLocation == city) {
            currentLocation = highway;
        }

        else if (currentLocation == highway) {
            currentLocation = mountain;
        }
    }

    public void BackLocation() { // goes back to a location

        if (currentLocation == zoo) {
            currentLocation = cage;
        } else if (currentLocation == city) {
            currentLocation = zoo;
        }

        else if (currentLocation == highway) {
            currentLocation = city;
        }

    }

}
