package mainPack.Mocks;

import mainPack.NotSureWhatToName.Condition;
import mainPack.NotSureWhatToName.Train;
import mainPack.colours.ColourFactory;
import mainPack.colours.IColour;
import mainPack.functions.FunctionFactory;
import mainPack.functions.IFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadConditions {
    List<IFunctions> functions;
    List<IColour> colours;

    ColourFactory colFactory = new ColourFactory();
    FunctionFactory funFactory = new FunctionFactory();
    Train myTrain;

    public ArrayList<Condition> createConditions(Train theTrain) throws IOException {
        ArrayList<Condition> conditionList = new ArrayList<>();
        myTrain = theTrain;
        String fileName = "mockTripConditions.csv";

        File myFile = new File(fileName);
        myFile.createNewFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(";");
                if (!line.isEmpty()) {
                    conditionList.add(stringToCondition(stringBuilder.toString()));
                }
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        return conditionList;
    }


    public Condition stringToCondition(String str) {
        functions = funFactory.availableFunctions(); // List of the functions
        colours = colFactory.availableColors(); // List of the colours

        String[] parts = str.split(";"); // Splits the String into a String[]


        Condition newCon = new Condition(myTrain);

        int colour = whichColour(parts[1]); // Returns the ID for the colour
        int function = whichFunction(parts[2]); // Returns the ID for the function

        newCon.setColour(colFactory.getColour(colour));
        newCon.setAction(funFactory.getFunction((function)));

        if (parts[3].equals("occurrence")) {
            newCon.setOption(1);
        } else {
            newCon.setOption(2);
        }
        newCon.setCount(Integer.parseInt(parts[4]));

        return newCon;
    }

    public int whichColour(String input) {
            switch (input) {
                case "green" -> {
                    return 1;
                }
                case "red" -> {
                    return 2;
                }
                case "blue" -> {
                    return 3;
                }
                case "yellow" -> {
                    return 4;
                }
                default -> {
                    System.out.println("Invalid colour input");
                    return 1000;
            }
        }
    }
    public int whichFunction(String input) {
        switch (input) {
            case "honks" -> {
                return 1;
            }
            case "stops for 3 seconds then continues" -> {
                return 2;
            }
            case "lights flashes" ->  {
                return 3;
            }
            default -> {
                System.out.println("Invalid function input");
                return 5000;
            }
        }
    }
}

