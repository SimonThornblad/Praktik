package mainPack.NotSureWhatToName;

import mainPack.NotSureWhatToName.Colour;
import mainPack.colours.IColour;

import java.util.ArrayList;

public class Train {

    private int colourCount;
    public ArrayList<IColour> colourList = new ArrayList<>();



    public int getColorCount(int colourValue){
        colourCount = 0;
        for (IColour colour: colourList){
            if (colour.returnId() == colourValue){
                colourCount++;
            }
        }
        return colourCount;
    }

    public IColour lastColour () {
        return colourList.get(colourList.size()-1);
    }

    public IColour getColour (int i) {
        return colourList.get(colourList.size()-i);
    }
}

