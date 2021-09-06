package mainPack.functions;

public class ThreeSecStop implements IFunctions{

    int id = 2;

    @Override
    public int getFunctionId() {
        return id;
    }

    @Override
    public String executeFunction() {

        System.out.println("[ACTION] The train stops");

        for(int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Seconds: [" + (i+1) + "] The train waits.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "starts again.";
    }

    public String toString(){
        return "stops for 3 seconds";
    }
}
