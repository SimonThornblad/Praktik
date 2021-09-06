package mainPack.colours;

public class Red implements IColour{

    int id = 2;

    @Override
    public int returnId() {
        return id;
    }

    public String toString() {
        return "Red";
    }
}
