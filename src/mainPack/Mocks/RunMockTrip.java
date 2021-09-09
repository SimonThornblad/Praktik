package mainPack.Mocks;

import mainPack.NotSureWhatToName.Train;
import mainPack.colours.IColour;
import mainPack.controller.SensorData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RunMockTrip {

    //IColour[] trackArray;
    //LoadMockTrip loadMockTrip;
    SensorData sensorData;

    String fileName = "inputData.csv";
    int lastUpdate = 0;

    public RunMockTrip(SensorData sensorData) throws Exception {
        //this.loadMockTrip = new LoadMockTrip();
        this.sensorData = sensorData;
        //this.trackArray = loadMockTrip.createArray();
    }

    public void autoTrip() throws Exception {

        for(int i = 0; i < 2; i++) {
            try {
                readInput();
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Error");
            }
            Thread.sleep(350);
            i--;
        }
    }
    public void readInput() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(",");
              //  stringBuilder.append(del);
                if (!line.isEmpty()) {
                    updateChecker(stringBuilder.toString());
                }
            }
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    public void updateChecker(String input) throws IOException {

        String[] parts = input.split(",");

        //parts[0] = boolean, continue running?
        //parts[1] = colour
        //parts[2] = update ID

        boolean available = Boolean.parseBoolean(parts[1]);

        if(Integer.parseInt(parts[3]) != lastUpdate && available) {
            WriteFile.writeAction(" ");
            int colour = whichColour(parts[2]);
            if(colour != 1000) {
                // call on action
                sensorData.setInputData(colour);
                //Updates the counter
                lastUpdate = Integer.parseInt(parts[3]);
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
                //System.out.println("Invalid colour input");
                return 1000;
            }
        }
    }
}
