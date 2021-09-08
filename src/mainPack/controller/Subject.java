package mainPack.controller;



public interface Subject {

    public void registerObserver  (Observer o);

    public void notifyObserver();
}
