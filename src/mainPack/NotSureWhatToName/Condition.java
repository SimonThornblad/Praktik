package mainPack.NotSureWhatToName;

public class Condition {
    public Colour colour;
    public Event action;
    public int occurrence = 1;
    public int sequential = 1;
    public Train theTrain;


    public Condition(){

    }
    public Condition(Colour colour, Event action, Train theTrain) {
        this.colour = colour;
        this.action = action;
        this.theTrain = theTrain;
    }

    public Condition(Colour colour, Event action, int occurrence, Train theTrain) {
        this.colour = colour;
        this.action = action;

        // If occurrence haven't been decided, set it to 1
        if (occurrence == 0) {
            occurrence = 1;
        } else {
            this.occurrence = occurrence;
        }
        this.theTrain = theTrain;
    }

    public boolean conditionChecker() {
        if (occurrence >= 1) {
            if(occurrenceChecker()) {
                return true;
            }
 //           return occurrenceChecker();
        }
        if (sequential>1) {
            return sequentialChecker();
        }
        return false;
    }

    public boolean occurrenceChecker() {
        // Returns the value of the specific counter
        int colourCounter = theTrain.whichCounter(colour);

        // Is the remainder 0?
        return colourCounter % occurrence == 0;
    }


    public boolean sequentialChecker() {


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

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    public int getSequential() {
        return sequential;
    }

    public void setSequential(int sequential) {
        this.sequential = sequential;
    }

    public Train getTheTrain() {
        return theTrain;
    }

    public void setTheTrain(Train theTrain) {
        this.theTrain = theTrain;
    }


}





