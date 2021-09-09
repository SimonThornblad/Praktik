package mainPack.functions;

import mainPack.Mocks.WriteFile;

import java.io.IOException;

public class FlashLights implements IFunctions{

    int id = 3;

    @Override
    public int getFunctionId() {
        return id;
    }

    @Override
    public String executeFunction() throws IOException {
        WriteFile.writeAction("[ACTION] The train flashes the lights");
        return "[ACTION] The train flashes the lights";
    }

    public String toString() {
        return " flashes the lights";
    }
}
