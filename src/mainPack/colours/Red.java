package mainPack.colours;

import java.util.Objects;

public class Red implements IColour{

    int id = 2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Red red = (Red) o;
        return id == red.id;
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
        return "Red";
    }
}
