package mainPack.NotSureWhatToName;

import mainPack.colours.IColour;

import java.util.ArrayList;
import java.util.Objects;

public class Train {

    private int colourCount;
    public ArrayList<IColour> colourList = new ArrayList<>();

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return colourCount == train.colourCount && Objects.equals(colourList, train.colourList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colourCount, colourList);
    }

     */

/*
    public void addCount (Colour colour) {
        switch(colour.toString()) {
            case "Green" -> greenCount++;
            case "Red" -> redCount++;
            case "Blue" -> blueCount++;
            case "Yellow" -> yellowCount++;
        }
    }

    public Colour colourCreator(int i) {
        switch (i) {
            case 1 -> {
                greenCount++;
                return new Colour("Green");
            }
            case 2 -> {
                redCount++;
                return new Colour("Red");
            }
            case 3 -> {
                blueCount++;
                return new Colour("Yellow");
            }
            case 4 -> {
                yellowCount++;
                return new Colour("Blue");
            }
            case 5 -> System.exit(1);
        }
        return null;
    }
*/

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

