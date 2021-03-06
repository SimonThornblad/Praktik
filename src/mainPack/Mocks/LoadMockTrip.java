package mainPack.Mocks;

import mainPack.colours.ColourFactory;
import mainPack.colours.IColour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class LoadMockTrip {

    IColour[] trackArray = new IColour[30];

    String fileName="mockTripColours.csv";


    public IColour[] createArray() throws Exception {
        int i = 0;
        File myFile = new File(fileName);
        myFile.createNewFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                if (!line.isEmpty()) {
                        for (IColour colour : ColourFactory.availableColors()) {
                            if(colour.toString().equalsIgnoreCase(stringBuilder.toString())) {
                                trackArray[i] = colour;
                            }
                        }
                    }
                stringBuilder.delete(0, stringBuilder.length());
                i++;
            }
        }
        return trackArray;
    }

}
