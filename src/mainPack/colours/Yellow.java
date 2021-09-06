package mainPack.colours;

import java.util.Objects;

public class Yellow implements IColour{

    int id = 4;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yellow yellow = (Yellow) o;
        return id == yellow.id;
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
        return "Yellow";
    }
}
