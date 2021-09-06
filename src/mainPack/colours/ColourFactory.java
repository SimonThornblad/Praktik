package mainPack.colours;

import java.util.List;

public class ColourFactory {

    private List<IColour> colours;

    public ColourFactory(List<IColour> colours) {
        this.colours = colours;
        colours.add(new Green());
        colours.add(new Red());
        colours.add(new Blue());
        colours.add(new Yellow());
    }

    public IColour getColour(int i) {
        return colours.get(i - 1);
    }

    public List<IColour> availableColors(){
        return colours;
    }
}
