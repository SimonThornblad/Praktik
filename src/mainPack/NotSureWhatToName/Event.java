package mainPack.NotSureWhatToName;

public class Event {
    public String whatHappens;

    public Event(String action) {
        this.whatHappens = action;
    }

    @Override
    public String toString() {
        return whatHappens;
    }
}
