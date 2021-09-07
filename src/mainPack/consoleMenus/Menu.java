package mainPack.consoleMenus;

import mainPack.NotSureWhatToName.Condition;
import mainPack.NotSureWhatToName.Train;
import mainPack.colours.ColourFactory;
import mainPack.colours.IColour;
import mainPack.functions.FunctionFactory;
import mainPack.functions.IFunctions;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner _scanner = new Scanner(System.in);
    ColourFactory colFactory;
    FunctionFactory funFactory;
    Train theTrain;


    public Menu(ColourFactory colFactory, FunctionFactory funFactory, Train theTrain) {
        this.colFactory = colFactory;
        this.funFactory = funFactory;
        this.theTrain = theTrain;
    }

    public ArrayList<Condition> conMenu(ArrayList<Condition> conditions) throws InterruptedException {

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
            newCondition.setAction(funFactory.getFunction(inScan()));

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
            conditions.add(newCondition);
        }
        // Initializes the trip
        return conditions;
    }
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
                for (IColour colour : colFactory.availableColors()) {
                    System.out.println(colour.returnId() + ". " + colour.toString());
                }
            }
            case "event" -> {
                System.out.println("What should happen when the train passes the colour?");
                for (IFunctions action : funFactory.availableFunctions()) {
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
                for (IColour colour: colFactory.availableColors()){
                    System.out.println("[" + colour.returnId() + ". " +
                            colour.toString() + "] ");
                }
                System.out.println("[" + (colFactory.availableColors().size()+1) + ". Exit]");
            }
        }
    }

    public int inScan() {
        return Integer.parseInt(_scanner.nextLine().trim());
    }

}
