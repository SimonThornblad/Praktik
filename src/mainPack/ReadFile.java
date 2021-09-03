package mainPack;

import mainPack.NotSureWhatToName.Colour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {
    /*

    Colour[] trackArray = new Colour[30];
    StartUp startUp = new StartUp();
    ArrayList<Colour> colourArrayList = startUp.createColours();


    public void createArray() throws Exception {
        int i = 0;
        File myFile = new File("mockTripData.csv");
        myFile.createNewFile();
        try (BufferedReader reader = new BufferedReader(new FileReader("mockTripData.csv"))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
       //     String del = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            //    stringBuilder.append(del);
                if (!line.isEmpty()) {
                    int c = colourDecider(stringBuilder.toString());
                    if (c!= 10) {
                        trackArray[i] = colourArrayList.get(c);
                    }
                }
                stringBuilder.delete(0, stringBuilder.length());
                i++;
            }
        }
        printArray();
    }

    public void printArray() {
        for(int i = 0; i < trackArray.length; i++)
            System.out.println(i+1 + " [" + trackArray[i] + "]");
    }

    public int colourDecider(String str) {
        switch (str) {
            case "green" -> {
                return 0;
            }
            case "red" -> {
                return 1;
            }
            case "yellow" -> {
                return 2;
            }
            case "blue" -> {
                return 3;
            }
        }
        return 10;
    }

     */

}
