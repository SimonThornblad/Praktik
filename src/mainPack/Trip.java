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
        conMenu();
    }

    private void conMenu() throws Exception{
        Scanner _scanner = new Scanner(System.in);
//=====================================================================================================================

        Train theTrain = new Train();

        Condition newCondition = new Condition(theTrain);


        while (true) {
            menus("newCon");
            if(Integer.parseInt(_scanner.nextLine()) == 2) {
                break;
            }

            // Sets the colour
            menus("colour");
            Colour newColour = new Colour(Integer.parseInt(_scanner.nextLine().trim()));
            newCondition.setColour(newColour);

            // Sets the event
            menus("event");
            int actionChoice = Integer.parseInt(_scanner.nextLine());
            Event newEvent = new Event(actions[actionChoice - 1]);
            newCondition.setAction(newEvent);

            // Sets the condition
            menus("condition");
            newCondition.setOption(Integer.parseInt(_scanner.nextLine()));

            switch (newCondition.getOption()) {
                case 1 -> {
                    // Sets the occurrence rate for the event
                    System.out.println("How often should it occur?");
                    // 1 = each time    2 = every second time ...
                    newCondition.setCount(Integer.parseInt(_scanner.nextLine()));
                }
                case 2 -> {
                    System.out.println("How many in a row?");
                    newCondition.setCount(Integer.parseInt(_scanner.nextLine()));
                }
                case 3 -> {
                    // What here??
                    newCondition.setCount(0);
                }
            }
            // Adds the condition to the list and loops back to the start
            conditionList.add(newCondition);
        }
        // Initializes the trip
        System.out.println(conditionList.size());
        trip(theTrain);
    }

    public void trip(Train theTrain) throws Exception{
        //==========  INPUT  ===================================================================================================
        Scanner _scanner = new Scanner(System.in);

        // This illustrates the actual input from the colour sensor
        while(true) {
            menus("colourInput");  // Prints the menu
            int input = Integer.parseInt(_scanner.nextLine());

            if(input == 5) {
                break;
            } else {
                theTrain.colourList.add(theTrain.colourCreator(input));
                actions(theTrain, conditionList);
                stringBuilder(theTrain);
            }
        }

        // Prints the colour list + colour counters
        printStuff(theTrain);
    }
//======================================================================================================================


    private void actions(Train theTrain, ArrayList<Condition> conList) {
        for(Condition con : conList) {
            // Checks if the last colour matches any Conditions.colour
            if(theTrain.colourList.get(theTrain.colourList.size()-1).toString().equals(con.colour.toString())) {
                // Checks if the condition is met
                if(con.conditionChecker()) {
                    System.out.println("The train " + con.action.toString() + ".");
                } else {
                    System.out.println("Condition exists but has not been met.");
                }
            } else {
                System.out.println("No condition exists for this colour.");
            }
        }
    }


//========== Printing methods for controlling ==========================================================================
    public void menus(String menuChoice) {
        switch (menuChoice) {
            case "newCon" -> {
                    System.out.println("Do you wish to add any condition?" +
                            "=============\n" +
                            " 1. Yes\n" +
                            " 2. No, initialize the trip\n" +
                            "\n==>");
            }
            case "colour" -> {
                System.out.println("Select a colour: ");
                for (String colour : colours) {
                    System.out.println(colour);
                }
            }
            case "event" -> {
                System.out.println("What should happen when the train passes the colour?");
                for (String action : actions) {
                    System.out.println("The train " + action + ".");
                }
            }
            case "condition" -> {
                System.out.println("Do you wish to add any condition?" +
                        "=============\n" +
                        " 1. Occurrence\n" +
                        " 2. Sequential\n" +
                        " 3. No\n" +
                        "\n==>");
            }
            case "colourInput" -> {

                System.out.println("\nWhich color do you pass?\n" +
                        "=============\n" +
                        " [1. Green] " +
                        " [2. Red] " +
                        " [3. Yellow] " +
                        " [4. Blue] " +
                        " [5. Exit] " +
                        "\n==>");
            }
        }
    }

    public void printStuff (Train theTrain) {
        stringBuilder(theTrain);
        printValues(theTrain);
        printConditions(conditionList);
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

    public void printConditions(ArrayList<Condition> conList) {
        for(Condition condition : conList) {
            System.out.println(condition.toString());
        }
    }

}
