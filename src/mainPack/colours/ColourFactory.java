package mainPack.colours;

import mainPack.NotSureWhatToName.Colour;

import java.util.ArrayList;
import java.util.List;

public class ColourFactory {

    private List<IColour> colours;

    public ColourFactory(List<IColour> colours) {
        this.colours = colours;
        colours.add(new Green());
        colours.add(new Red());
        colours.add(new Blue());
    }

    public IColour getColour(int i) {
        return colours.get(i - 1);
        /*
        switch (i){
            case 1 ->{
                return new Green();
            }
            case 2 -> {
                return new Red();
            }
        }
        return null;

         */
    }

    public List<IColour> availableColors(){
        return colours;
    }
}
