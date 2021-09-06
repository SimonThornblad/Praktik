package mainPack.functions;

public class FlashLights implements IFunctions{

    int id = 3;

    @Override
    public int getFunctionId() {
        return id;
    }

    @Override
    public String executeFunction() {
        return "flashes the lights";
    }

    public String toString() {
        return " flashes the lights";
    }
}
