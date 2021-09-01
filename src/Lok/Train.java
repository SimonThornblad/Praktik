package Lok;

import java.util.ArrayList;

public class Train {
    int greenCount;
    int redCount;
    int blueCount;
    int yellowCount;
    ArrayList<Colour> colourList = new ArrayList<>();

    public Train(){
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

}










