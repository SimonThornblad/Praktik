package mainPack;


import mainPack.Mocks.LoadConditions;
import mainPack.Mocks.LoadMockTrip;
import mainPack.Mocks.RunMockTrip;
import mainPack.NotSureWhatToName.Condition;

import mainPack.NotSureWhatToName.Train;
import mainPack.colours.ColourFactory;
import mainPack.colours.IColour;
import mainPack.consoleMenus.Menu;
import mainPack.controller.Observer;
import mainPack.controller.SensorData;
import mainPack.engineControll.TrainEngine;
import mainPack.functions.FunctionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Trip implements Observer {
    //List<IFunctions> functions;
    //List<IColour> colours;
    //ColourFactory colFactory = new ColourFactory();
    //FunctionFactory funFactory = new FunctionFactory();
    SensorData sensorData;
    ArrayList<Condition> conditionList = new ArrayList<>();

    // Creating array for simulation
    //LoadMockTrip fileRead = new LoadMockTrip();
    LoadConditions conRead = new LoadConditions();
    Train theTrain = new Train();

    public Trip(SensorData sensorData) throws Exception {

        this.sensorData = sensorData;
        sensorData.registerObserver(this);
    }


    public void init() throws Exception {
        //functions = funFactory.availableFunctions();
        //colours = colFactory.availableColors();
        //fileRead.createArray();
        conditionList = conRead.createConditions(theTrain);

        Menu menu = new Menu(theTrain);
        menu.conMenu(conditionList);

        RunMockTrip runMock = new RunMockTrip(sensorData);
        TrainEngine.startEngine();
        runMock.autoTrip();
        //autoTrip(theTrain);
   //     autoTrip(theTrain);
    }



//==========  INPUT  ===============================================================================================
    /*
    public void trip(Train theTrain) {

        // This illustrates the actual input from the colour sensor
        while(true) {
            menus("colourInput");  // Prints the menu
            int input = Integer.parseInt(_scanner.nextLine());

            if(input == colours.size()+1) {
                break;
            } else {
                theTrain.colourList.add(colFactory.getColour(input));
                actions(theTrain, conditionList);
                stringBuilder(theTrain);
            }
        }

        // Prints the colour list + colour counters
        printStuff(theTrain);
    }

     */
/*
    public void autoTrip(Train theTrain) throws InterruptedException {

        for(int i = 0; i < trackArray.length; i++) {
            if(trackArray[i] != null) {
                theTrain.colourList.add(trackArray[i]);
                System.out.print("Index [" + (i+1) + "]: " + trackArray[i]+ "\n");
                actions(theTrain, conditionList);
            } else {
                System.out.println("Index [" + (i+1)+ "]");
            }
            TimeUnit.MILLISECONDS.sleep(1000L);
        }
        printStuff(theTrain);
    }

 */


//======================================================================================================================


    private void actions(Train theTrain, ArrayList<Condition> conList) throws IOException {

        // Finds the conditions with the same colour as the last one, then checks if the conditions are met
        for(Condition con : conList) {
            if(theTrain.lastColour().equals(con.colour)) {
                if(con.conditionChecker()) {
                    System.out.println(con.action.executeFunction());
                } else {
      //              System.out.println("Condition exists but has not been met.");
                }
            } else {
   //             System.out.println("No condition exists for this colour.");
            }
        }
    }

//========== Printing methods for controlling ==========================================================================

    public void printStuff (Train theTrain) {
        stringBuilder(theTrain);
        printValues(theTrain);
        printConditions(conditionList);
    }

    public void stringBuilder (Train theTrain) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < theTrain.colourList.size(); i++) {
            sb.append(theTrain.colourList.get(i));
            sb.append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append("]");

        System.out.println("Order: " + sb);
    }

    public void printValues(Train theTrain) {
        /*
        System.out.println("Green: " + theTrain.greenCount +
                "\nRed: " + theTrain.redCount +
                "\nBlue: " + theTrain.blueCount +
                "\nYellow: " + theTrain.yellowCount);

         */
    }

    public void printConditions(ArrayList<Condition> conList) {

        for(int i = 0; i < conList.size(); i++) {
            System.out.println((i+1) +". " + conList.get(i).toString());
        }
    }

    @Override
    public void update(int sensorInput) throws IOException {
        if (TrainEngine.isMotorRunning()) {
            validateColour(sensorInput);
        }
    }

    public void validateColour(int sensorInput) throws IOException {
        for (IColour colour : ColourFactory.availableColors()) {
            if (colour.returnId() == sensorInput){
                theTrain.colourList.add(colour);
                actions(theTrain, conditionList);
            }
        }
    }
}
