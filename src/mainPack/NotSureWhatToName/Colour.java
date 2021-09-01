package mainPack.NotSureWhatToName;

public class Colour {
    public String name;

    public Colour(String name) {
        this.name = name;
    }

    public Colour (int i) {
        switch (i) {
            case 1 -> {
                this.name = "Green";
            }
            case 2 -> {
                this.name = "Red";
            }
            case 3 -> {
                this.name = "Yellow";
            }
            case 4 -> {
                this.name = "Blue";
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
