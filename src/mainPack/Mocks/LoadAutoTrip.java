package mainPack.Mocks;

import mainPack.colours.ColourFactory;
import mainPack.colours.IColour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class LoadAutoTrip {

    String fileName = "inputData.csv";
    int lastUpdate = 0;

    public void readInput() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(";");
                if (!line.isEmpty()) {
                    updateChecker(stringBuilder.toString());
                }
            }
            stringBuilder.delete(0, stringBuilder.length());
        }
    }


    public void updateChecker(String input) {

        String[] parts = input.split(";");

        //parts[0] = boolean, continue running?
        //parts[1] = colour
        //parts[2] = update ID

        if(Integer.parseInt(parts[2]) != lastUpdate) {
            int colour = whichColour(parts[1]);
            if(colour != 1000) {
                // call on action
            }
        }
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

}

