package mainPack.functions;

import java.io.IOException;

public interface IFunctions {

    public int getFunctionId();

    public String executeFunction() throws IOException;

    public String toString();
}
