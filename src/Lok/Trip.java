package Lok;

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

//=====================================================================================================================

        Scanner _scanner = new Scanner(System.in);
        // Sets the colour
        System.out.println("Select a colour: ");
        for (String colour : colours) {
            System.out.println(colour);
        }
        Colour newColour = colourCreator(Integer.parseInt(_scanner.nextLine()));


        // Sets the condition for the selected colour
        System.out.println("What should happen when the train passes " + newColour.toString() + "?");
        for (String action : actions) {
            System.out.println("The train " + action + ".");
        }
        String newAction = _scanner.nextLine();


        // Creates the event
        conditionList.add(new Condition(newColour, newAction));

//        actionStore(newColour, newAction);

        // Initializes the trip
        trip();


    }

    private void trip() throws Exception{
        //==========  INPUT  ===================================================================================================
        Scanner _scanner = new Scanner(System.in);

        Train theTrain = new Train();

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
            }

        }



        actions(theTrain.colourList);

        // Prints the colour list
        printValues(theTrain);
        System.out.println(stringBuilder(theTrain));

//======================================================================================================================
    }




    private void actionStore(Colour colour, String action) {
        conditionList.add(new Condition(colour, action));
    }


    private void actions(ArrayList<Colour> colourList) {
        for(Condition condition : conditionList) {
            if(colourList.get(colourList.size()-1) == condition.colour) {
                System.out.println("The train " + condition.action + ".");
            }
        }
    }
    private Colour colourCreator(int i) {
        switch (i) {
            case 1 -> {
                return new Colour("Green");
            }
            case 2 -> {
                return new Colour("Red");
            }
            case 3 -> {
                return new Colour("Yellow");
            }
            case 4 -> {
                return new Colour("Blue");
            }
            case 5 -> System.exit(1);
        }
        return null;
    }

    public String stringBuilder (Train theTrain) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < theTrain.colourList.size(); i++) {
            sb.append(theTrain.colourList.get(i));
            sb.append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append("]");

        return sb.toString();
    }

    public void printValues(Train theTrain) {
        System.out.println("Green: " + theTrain.greenCount +
                "\nRed: " + theTrain.redCount +
                "\nBlue: " + theTrain.blueCount +
                "\nYellow: " + theTrain.yellowCount);
    }

}
