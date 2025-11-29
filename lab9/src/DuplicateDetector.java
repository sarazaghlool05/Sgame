import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateDetector {
    public static List<Duplicate> findDuplicates(int[] values, String type, int index){
        List<Duplicate> duplicates = new ArrayList<>();
        Map<Integer, List<Integer>> valuePositions = new HashMap<>();

        for (int position = 0; position < values.length; position++) {
            int value = values[position];
            valuePositions.putIfAbsent(value, new ArrayList<>());
            valuePositions.get(value).add(position);
        }

        for (Map.Entry<Integer, List<Integer>> entry : valuePositions.entrySet()) {
            List<Integer> positions = entry.getValue();

            if (positions.size() > 1) {
                int value = entry.getKey();
                duplicates.add(new Duplicate(type, index, value, positions));
            }
        }
        return duplicates;
    }
}
