package mainPack.NotSureWhatToName;

public class Condition {
    public Colour colour;
    public Event action;
    //public int occurrence = 1;
    //public int sequential = 1;
    public Train theTrain;
    public int option;
    public int count;

    public Condition(){
    }

    @Override
    public String toString() {
        return "Condition{" +
                "colour=" + colour +
                ", action=" + action +
                ", theTrain=" + theTrain +
                ", option=" + option +
                ", count=" + count +
                '}';
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
        int colourCounter = theTrain.whichCounter(colour);

        // Is the remainder 0?
        return colourCounter % count == 0;
    }


    public boolean sequentialChecker() {

        int arraySize = theTrain.colourList.size();

        for (int i = count; i > 0; i-- ){
            if (i > arraySize ||
                    !theTrain.colourList.get(arraySize-1).toString().equals(theTrain.colourList.get(arraySize-i).toString())){
                return false;
            }
        }
        return true;
    }


    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Event getAction() {
        return action;
    }

    public void setAction(Event action) {
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





