import java.util.ArrayList;
import java.util.List;

public class Duplicate implements Comparable<Duplicate>{
    private final String type;
    private final int index;
    private final int value;
    private final List<Integer> positions;

    public Duplicate(String type, int index, int value, List<Integer> positions) {
        this.type = type;
        this.index = index;
        this.value = value;
        this.positions = new ArrayList<>();
        for (int position : positions) {
            this.positions.add(position + 1);
        }
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

    @Override
    public int compareTo(Duplicate other) {
        int typeCompare = this.type.compareTo(other.type);
        if (typeCompare != 0){
            return typeCompare;
        }
        if (this.index != other.index) {
            return Integer.compare(this.index, other.index);
        }
        return Integer.compare(this.value, other.value);
    }
}