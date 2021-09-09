package mainPack.functions;

public class Honk implements IFunctions{
    int id = 1;

    @Override
    public int getFunctionId() {
        return id;
    }

    @Override
    public String executeFunction() {
        return "[ACTION] The train says tut tut";
    }

    public String toString() {
        return "honks";
    }
}
