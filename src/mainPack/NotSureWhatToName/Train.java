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
}










