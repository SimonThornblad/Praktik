package mainPack.engineControll;

import mainPack.Mocks.WriteFile;

import java.io.IOException;

public class TrainEngine {

    private static boolean motorRunning = false;

    public static boolean isMotorRunning() {
        return motorRunning;
    }

    public static void setMotorRunning(boolean motorRunning) {
        TrainEngine.motorRunning = motorRunning;
    }

    public static void stopEngine() throws IOException {
        motorRunning = false;
        WriteFile.writeAction("[ACTION] The train stops");
        System.out.println("[ACTION] The train stops");
    }

    public static void startEngine() throws IOException {
        motorRunning = true;
        WriteFile.writeAction("[ACTION] The train starts");
        System.out.println("[ACTION] The train starts");
    }
}
