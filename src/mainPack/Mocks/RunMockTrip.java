package mainPack.Mocks;

import mainPack.NotSureWhatToName.Train;
import mainPack.colours.IColour;

import java.util.concurrent.TimeUnit;

public class RunMockTrip {

    IColour[] trackArray;
    LoadMockTrip loadMockTrip;

    public RunMockTrip() throws Exception {
        this.loadMockTrip = new LoadMockTrip();
        this.trackArray = loadMockTrip.createArray();
    }

    public void autoTrip() throws InterruptedException {



        for(int i = 0; i < trackArray.length; i++) {
            if(trackArray[i] != null) {
                trackArray[i].returnId();
                //theTrain.colourList.add(trackArray[i]);
                System.out.print("Index [" + (i+1) + "]: " + trackArray[i]+ "\n");
               // actions(theTrain, conditionList);
            } else {
                System.out.println("Index [" + (i+1)+ "]");
            }
            TimeUnit.MILLISECONDS.sleep(1000L);
        }
    }
}
