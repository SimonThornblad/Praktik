package mainPack.controller;

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
    public void notifyObserver() {
        for (Observer observer: observers){
            observer.update(sensorInput);
        }
    }

    public void newInuptData (){
        notifyObserver();
    }

    public void setInputData(int sensorInput) {
        this.sensorInput = sensorInput;
        newInuptData();
    }
}
