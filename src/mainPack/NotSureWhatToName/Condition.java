package mainPack.NotSureWhatToName;

import mainPack.colours.IColour;
import mainPack.functions.IFunctions;

public class Condition {
    public IColour colour;
    public IFunctions action;
    public Train theTrain;
    public int option;
    public int count;

    public Condition(){
    }




    @Override
    public String toString() {
        String opt = "Occurrence";
        if(option == 2) {
            opt = "Sequential";
        }
        return "Condition [" +
                "Colour: " + colour +
                ", Action: " + action +
                ", Option: " + opt +
                ", Every: " + count +
                            ']';
    }

    public Condition(Train train) {
        this.theTrain = train;
    }

    public boolean conditionChecker() {
        if (this.option == 1) {
            return occurrenceChecker();
        }
        else if (option == 2) {
            return sequentialChecker();
        }
        return option == 3;
    }

    public boolean occurrenceChecker() {
        // Returns the value of the specific counter
        int colourCounter = theTrain.getColorCount(colour.returnId());

        // Is the remainder 0?
        return colourCounter % count == 0;
    }


    public boolean sequentialChecker() {

        int arraySize = theTrain.colourList.size();

        for (int i = count; i > 0; i-- ){
            if (i > arraySize || !theTrain.colourList.get(arraySize -1).toString().equals(theTrain.colourList.get(arraySize - i).toString())) {
                return false;
            }
        }
        return true;
    }


    public IColour getColour() {
        return colour;
    }

    public void setColour(IColour colour) {
        this.colour = colour;
    }

    public IFunctions getAction() {
        return action;
    }

    public void setAction(IFunctions action) {
        this.action = action;
    }

    public Train getTheTrain() {
        return theTrain;
    }

    public void setTheTrain(Train theTrain) {
        this.theTrain = theTrain;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}





