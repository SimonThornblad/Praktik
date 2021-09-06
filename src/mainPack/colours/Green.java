package mainPack.colours;

import java.util.Objects;

public class Green implements IColour{

    int id = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Green green = (Green) o;
        return id == green.id;
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
        return "Green";
    }
}
