package mainPack.colours;

public class Yellow implements IColour{

    int id = 4;

    @Override
    public int returnId() {
        return id;
    }

    public String toString() {
        return "Yellow";
    }
}
