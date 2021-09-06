package mainPack.functions;

public class Honk implements IFunctions{
    int id = 1;

    @Override
    public int getFunctionId() {
        return id;
    }

    @Override
    public void executeFunction() {

    }

    public String toString() {
        return "the train honks";
    }
}
