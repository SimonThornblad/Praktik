package mainPack.engineControll;

public class TrainEngine {

    private static boolean motorRunning = false;

    public static boolean isMotorRunning() {
        return motorRunning;
    }

    public static void setMotorRunning(boolean motorRunning) {
        TrainEngine.motorRunning = motorRunning;
    }

    public static void stopEngine() {
        motorRunning = false;
        System.out.println("[ACTION] The train stops");
    }

    public static void startEngine() {
        motorRunning = true;
        System.out.println("[ACTION] The train starts again");
    }
}
