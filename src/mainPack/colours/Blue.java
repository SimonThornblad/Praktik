package mainPack.colours;

public class Blue implements IColour{

    int id = 3;

    @Override
    public int returnId() {
        return id;
    }

    public String toString() {
        return "Blue";
    }
}

