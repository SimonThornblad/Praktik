package mainPack;

import mainPack.NotSureWhatToName.Colour;
import mainPack.NotSureWhatToName.Condition;
import mainPack.NotSureWhatToName.Event;
import mainPack.NotSureWhatToName.Train;
import mainPack.colours.ColourFactory;
import mainPack.colours.IColour;
import mainPack.functions.FunctionFactory;
import mainPack.functions.IFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Trip {
    //StartUp startUp = new StartUp();
    //ArrayList<Colour> colourArrayList = startUp.createColours();
    //ArrayList<Event> eventArrayList = startUp.createEvent();
    List<IFunctions> functions;
    List<IColour> colours;
    ColourFactory colFactory = new ColourFactory(new ArrayList<>());
    FunctionFactory funFactory = new FunctionFactory(new ArrayList<>());

    ArrayList<Condition> conditionList = new ArrayList<>();
    Scanner _scanner = new Scanner(System.in);

    // Creating array for simulation
    ReadFile fileRead = new ReadFile();
    IColour[] trackArray = new IColour[30];



    public Trip() throws Exception {
    }


    public void init() throws Exception {
        functions = funFactory.availableFunctions();
        colours = colFactory.availableColors();
        trackArray = fileRead.createArray(colours);

        conMenu();
    }

    private void conMenu() throws InterruptedException {
        Train theTrain = new Train();

        while (true) {
            Condition newCondition = new Condition(theTrain);
            // Add a condition Y/N?
            menus("newCon");
            if(inScan() == 2) {
                break;
            }

            // Sets the colour
            menus("colour");
            newCondition.setColour(colFactory.getColour(inScan()));

            // Sets the event
            menus("event");
            newCondition.setAction(new Event(funFactory.getFunction(inScan())));

            // Sets the condition
            menus("condition");
            newCondition.setOption(inScan());

            switch (newCondition.getOption()) {
                case 1 -> {
                    // Sets the occurrence rate for the event
                    System.out.println("How often should it occur?");
                    // 1 = each time    2 = every second time ...
                    newCondition.setCount(inScan());
                }
                case 2 -> {
                    // Sets the sequential rate for the event
                    System.out.println("How many in a row?");
                    newCondition.setCount(inScan());
                }
                case 3 -> newCondition.setCount(0);
            }
            // Adds the condition to the list and loops back to the start
            conditionList.add(newCondition);
        }
        // Initializes the trip
        autoTrip(theTrain);
    }

//==========  INPUT  ===============================================================================================
    public void trip(Train theTrain) {

        // This illustrates the actual input from the colour sensor
        while(true) {
            menus("colourInput");  // Prints the menu
            int input = Integer.parseInt(_scanner.nextLine());

            if(input == colours.size()+1) {
                break;
            } else {
                theTrain.colourList.add(colFactory.getColour(input));
                actions(theTrain, conditionList);
                stringBuilder(theTrain);
            }
        }

        // Prints the colour list + colour counters
        printStuff(theTrain);
    }

    public void autoTrip(Train theTrain) throws InterruptedException {

        for(int i = 0; i < trackArray.length; i++) {

            if(trackArray[i] != null) {
                theTrain.colourList.add(trackArray[i]);

                System.out.print("\nIndex [" + (i+1) + "]: " + trackArray[i] + "  ");
                actions(theTrain, conditionList);
                stringBuilder(theTrain);
                System.out.println();



            } else {
                System.out.println("Index [" + (i+1)+ "]");

            }

            TimeUnit.MILLISECONDS.sleep(200L);
        }
        printStuff(theTrain);

    }


//======================================================================================================================


    private void actions(Train theTrain, ArrayList<Condition> conList) {

        // Finds the conditions with the same colour as the last one, then checks if the conditions are met
        for(Condition con : conList) {
            if(theTrain.lastColour().equals(con.colour)) {
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
            case "newCon" ->
                    System.out.println("Do you wish to add any condition?" +
                            "=============\n" +
                            " 1. Yes\n" +
                            " 2. No, initialize the trip\n" +
                            "\n==>");

            case "colour" -> {
                System.out.println("Select a colour: ");
                for (IColour colour : colours) {
                    System.out.println(colour.returnId() + ". " + colour.toString());
                }
            }
            case "event" -> {
                System.out.println("What should happen when the train passes the colour?");
                for (IFunctions action : functions) {
                    System.out.println(action.getFunctionId() + ". The train " + action.toString() + ".");
                }
            }
            case "condition" ->
                System.out.println("Do you wish to add any condition?" +
                        "=============\n" +
                        " 1. Occurrence\n" +
                        " 2. Sequential\n" +
                        " 3. No\n" +
                        "\n==>");

            case "colourInput" -> {
                System.out.println("\nWhich color do you pass?\n" +
                        "=============\n");
                for (IColour colour: colours){
                    System.out.println("[" + colour.returnId() + ". " +
                            colour.toString() + "] ");
                }
                System.out.println("[" + (colours.size()+1) + ". Exit]");
            }
        }
    }

    public int inScan() {
        return Integer.parseInt(_scanner.nextLine().trim());
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

        System.out.println("Order: " + sb);
    }

    public void printValues(Train theTrain) {
        /*
        System.out.println("Green: " + theTrain.greenCount +
                "\nRed: " + theTrain.redCount +
                "\nBlue: " + theTrain.blueCount +
                "\nYellow: " + theTrain.yellowCount);

         */
    }



    public void printConditions(ArrayList<Condition> conList) {
        for(Condition condition : conList) {
            System.out.println(condition.toString());
        }
    }

}
