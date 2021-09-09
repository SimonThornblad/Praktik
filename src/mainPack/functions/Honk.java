package mainPack.functions;

import mainPack.Mocks.WriteFile;

import java.io.IOException;

public class Honk implements IFunctions{
    int id = 1;

    @Override
    public int getFunctionId() {
        return id;
    }

    @Override
    public String executeFunction() throws IOException {

        WriteFile.writeAction("[ACTION] The train says tut tut");
        return "[ACTION] The train says tut tut";
    }

    public String toString() {
        return "honks";
    }
}
