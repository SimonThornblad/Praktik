package mainPack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SensorData implements Subject{

    private List<Observer> observers;
    private int sensorInput;

    public SensorData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObserver() throws IOException {
        for (Observer observer: observers){
            observer.update(sensorInput);
        }
    }

    public void newInuptData () throws IOException {
        notifyObserver();
    }

    public void setInputData(int sensorInput) throws IOException {
        this.sensorInput = sensorInput;
        newInuptData();
    }
}
