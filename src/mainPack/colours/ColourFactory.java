package mainPack.colours;

import java.util.ArrayList;
import java.util.List;

public class ColourFactory {

    private static List<IColour> colours;
    //private List<IColour> colours;

    public ColourFactory() {
        this.colours = new ArrayList<>();
        colours.add(new Green());
        colours.add(new Red());
        colours.add(new Blue());
        colours.add(new Yellow());
    }

    public IColour getColour(int i) {
        return colours.get(i - 1);
    }

    public static List<IColour> availableColors(){
        return colours;
    }
}
