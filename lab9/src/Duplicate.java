import java.util.ArrayList;
import java.util.List;

public class Duplicate {
    private final String type;
    private final int index;
    private final int value;
    private final List<Integer> positions;

    public Duplicate(String type, int index, int value, List<Integer> positions) {
        this.type = type;
        this.index = index;
        this.value = value;
        this.positions = new ArrayList<>(positions);
    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPositions() {
        return new ArrayList<>(positions);
    }

    @Override
    public String toString() {
        return String.format("%s %d, #%d, %s", type, index, value, positions);
    }
}