package mainPack.colours;

public class Green implements IColour{

    int id = 1;

    @Override
    public int returnId() {
        return id;
    }

    public String toString() {
        return "Green";
    }
}
