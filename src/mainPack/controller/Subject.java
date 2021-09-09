package mainPack.controller;


import java.io.IOException;

public interface Subject {

    public void registerObserver  (Observer o);

    public void notifyObserver() throws IOException;
}
