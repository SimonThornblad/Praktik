package mainPack.colours;

import java.util.Objects;

public class Blue implements IColour{

    int id = 3;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blue blue = (Blue) o;
        return id == blue.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int returnId() {
        return id;
    }

    public String toString() {
        return "Blue";
    }
}

