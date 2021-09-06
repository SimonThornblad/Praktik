package mainPack.NotSureWhatToName;

import mainPack.NotSureWhatToName.Colour;

import java.util.ArrayList;

public class Train {
    public int greenCount;
    public int redCount;
    public int blueCount;
    public int yellowCount;
    public ArrayList<Colour> colourList = new ArrayList<>();

    public Train() {
    }



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

    public int whichCounter(Colour colour) {
        switch (colour.toString()) {
            case "Green" -> {
                return greenCount;
            }
            case "Red" -> {
                return redCount;
            }
            case "Blue" -> {
                return blueCount;
            }
            case "Yellow" -> {
                return yellowCount;
            }
        }
        return 100;
    }

    public Colour lastColour () {
        return colourList.get(colourList.size()-1);
    }

    public Colour getColour (int i) {
        return colourList.get(colourList.size()-i);
    }
}










