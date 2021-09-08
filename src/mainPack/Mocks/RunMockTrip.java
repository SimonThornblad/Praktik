package mainPack.Mocks;

import mainPack.NotSureWhatToName.Train;
import mainPack.colours.IColour;
import mainPack.controller.SensorData;

import java.util.concurrent.TimeUnit;

public class RunMockTrip {

    IColour[] trackArray;
    LoadMockTrip loadMockTrip;
    SensorData sensorData;

    public RunMockTrip(SensorData sensorData) throws Exception {
        this.loadMockTrip = new LoadMockTrip();
        this.sensorData = sensorData;
        this.trackArray = loadMockTrip.createArray();
    }

    public void autoTrip() throws InterruptedException {

        for(int i = 0; i < trackArray.length; i++) {

            if(trackArray[i] != null) {
                System.out.print("Index [" + (i+1) + "]: " + trackArray[i]+ "\n");
                sensorData.setInputData(trackArray[i].returnId());
            } else {
                System.out.println("Index [" + (i+1)+ "]");
            }
            TimeUnit.MILLISECONDS.sleep(500L);
        }
    }
}
