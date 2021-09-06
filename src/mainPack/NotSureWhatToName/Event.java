package mainPack.NotSureWhatToName;

import mainPack.functions.IFunctions;

public class Event {
    public IFunctions whatHappens;

    public Event(IFunctions action) {
        this.whatHappens = action;
    }

    @Override
    public String toString() {
        return whatHappens.toString();
    }
}
