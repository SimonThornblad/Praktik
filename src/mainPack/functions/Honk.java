package mainPack.functions;

public class Honk implements IFunctions{
    int id = 1;

    @Override
    public int getFunctionId() {
        return id;
    }

    @Override
    public String executeFunction() {
        /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */


        return "tut tut";
    }

    public String toString() {
        return "honks";
    }
}
