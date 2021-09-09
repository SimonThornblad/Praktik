package mainPack.Mocks;

import java.io.*;

public class WriteFile {

    public static void writeAction(String action) throws IOException {

        String fileName = "outputData.csv";

        FileOutputStream fileOutput = new FileOutputStream(fileName, false);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutput));

        bw.write(action);

        bw.flush();
        bw.close();

    }
}
