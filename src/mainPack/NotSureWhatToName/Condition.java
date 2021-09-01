package mainPack.NotSureWhatToName;

public class Condition {
    public Colour colour;
    public Event action;
    public int occurrence = 1;
    public Train theTrain;



    public Condition(Colour colour, Event action, int occurrence, Train theTrain) {
        this.colour = colour;
        this.action = action;
        this.occurrence = occurrence;
        this.theTrain = theTrain;
    }

    public boolean occurrenceChecker() {
        // Returns the value of the specific counter
        int colourCounter = theTrain.whichCounter(colour);

        // Is the remainder 0?
        return colourCounter % occurrence == 0;
    }
}





