package mainPack.functions;

public class ThreeSecStop implements IFunctions{

    int id = 2;

    @Override
    public int getFunctionId() {
        return id;
    }

    @Override
    public String executeFunction() {

        System.out.println("The train stops");

        for(int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Seconds: [" + (i+1) + "]");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "The train starts again";
    }

    public String toString(){
        return "stops for 3 seconds";
    }
}