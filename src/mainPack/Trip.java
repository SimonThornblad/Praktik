package mainPack;

import mainPack.NotSureWhatToName.Colour;
import mainPack.NotSureWhatToName.Condition;
import mainPack.NotSureWhatToName.Event;
import mainPack.NotSureWhatToName.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class Trip {

    String[] actions = new String[]{"stops", "honks", "stops for 3 seconds then continues", "does nothing"};
    String[] colours = new String[]{"Green", "Red", "Yellow", "Blue"};
    ArrayList<Condition> conditionList = new ArrayList<>();
    Scanner _scanner;

    public void init() throws Exception {
        menu();
    }

    private void menu() throws Exception{
        Scanner _scanner = new Scanner(System.in);
//=====================================================================================================================

        Train theTrain = new Train();

        // Sets the colour
        System.out.println("Select a colour: ");
        for (String colour : colours) {
            System.out.println(colour);
        }
        Colour newColour = new Colour(Integer.parseInt(_scanner.nextLine().trim()));

        // Sets the event for the selected colour
        System.out.println("What should happen when the train passes " + newColour.toString() + "?");
        for (String action : actions) {
            System.out.println("The train " + action + ".");
        }
        int actionChoice = Integer.parseInt(_scanner.nextLine());
        Event newEvent = new Event(actions[actionChoice]);


        System.out.println("Do you wish to add any condition?" +
                "=============\n" +
                " 1. Occurrence\n" +
                " 2. Sequential\n" +
                " 3. No\n" +
                "\n==>");

        int choice = Integer.parseInt(_scanner.nextLine());
        switch (choice) {
            case 1 -> {
                // Sets the occurrence rate for the event
                System.out.println("How often should it occur?");
                // 1 = each time    2 = every second time ...
                int occurrenceChoice = Integer.parseInt(_scanner.nextLine());
            }
            case 2 -> {
                System.out.println("How many in a row?");
                int sequentialChoice = Integer.parseInt(_scanner.nextLine());

            }
            case 3 -> {
                // What here??
            }
        }


        // Sets the occurrence rate for the event
        System.out.println("How often should it occur?");
        // 1 = each time    2 = every second time ...
        int occurrenceChoice = Integer.parseInt(_scanner.nextLine());

        // Creates the condition
        conditionList.add(new Condition(newColour, newEvent, occurrenceChoice, theTrain));
//        conditionList.add(new Condition(newColour, newEvent));

        // Initializes the trip
        trip(theTrain);


    }

    public void trip(Train theTrain) throws Exception{
        //==========  INPUT  ===================================================================================================
        Scanner _scanner = new Scanner(System.in);

//        Train theTrain = new Train();

        // This illustrates the actual input from the colour sensor
        while(true) {
            System.out.println("\nWhich color do you pass?\n" +
                    "=============\n" +
                    " 1. Green\n" +
                    " 2. Red\n" +
                    " 3. Yellow\n" +
                    " 4. Blue\n" +
                    " 5. Exit\n" +
                    "\n==>");

            int input = Integer.parseInt(_scanner.nextLine());

            if(input == 5) {
                break;
            } else {
                theTrain.colourList.add(theTrain.colourCreator(input));
                actions(theTrain, conditionList);
            }

        }


        // Prints the colour list + colour counters
        printStuff(theTrain);
    }
//======================================================================================================================


    private void actions(Train theTrain, ArrayList<Condition> conList) {
        for(Condition condition : conList) {
            // Checks if the last colour matches any Conditions.colour
            if(theTrain.colourList.get(theTrain.colourList.size()-1).toString().equals(condition.colour.toString())) {
                // Checks if occurrence has been met
                if(condition.occurrenceChecker()) {
                    // Action when the condition is met
                    System.out.println("The train " + condition.action.toString() + ".");
                }
            } else {
                System.out.println("No condition as been met");
            }
        }
    }


//========== Printing methods for controlling ==========================================================================
    public void printStuff (Train theTrain) {
        stringBuilder(theTrain);
        printValues(theTrain);
    }

    public void stringBuilder (Train theTrain) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < theTrain.colourList.size(); i++) {
            sb.append(theTrain.colourList.get(i));
            sb.append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append("]");

        System.out.println("Order: " + sb.toString());
    }

    public void printValues(Train theTrain) {
        System.out.println("Green: " + theTrain.greenCount +
                "\nRed: " + theTrain.redCount +
                "\nBlue: " + theTrain.blueCount +
                "\nYellow: " + theTrain.yellowCount);
    }

}
