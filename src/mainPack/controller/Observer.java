package mainPack.controller;

import java.io.IOException;

public interface Observer {

    public void update(int sensorInput) throws IOException;
}
