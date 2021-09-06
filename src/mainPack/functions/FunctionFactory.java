package mainPack.functions;

import java.util.List;

public class FunctionFactory {

    private static List<IFunctions> functions;
    //private List<IFunctions> functions;

    public FunctionFactory(List<IFunctions> functions) {
        this.functions = functions;
        functions.add(new Honk());
        functions.add(new ThreeSecStop());
        functions.add(new FlashLights());

    }

    public IFunctions getFunction(int i){
        return functions.get(i - 1);
    }

    public List<IFunctions> availableFunctions() {
        return functions;
    }
}
