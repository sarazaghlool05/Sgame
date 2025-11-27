import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult {
    private final List<Duplicate> duplicates = new ArrayList<>();
    private boolean isValid = true;

    public synchronized boolean isValid(){
        return isValid;
    }

    public synchronized void addDuplicate(Duplicate duplicate){
        this.duplicates.add(duplicate);
        this.isValid = false;
    }

    public synchronized List<Duplicate> getDuplicates(){
        return new ArrayList<>(duplicates);
    }

    public synchronized List<Duplicate> getSortedDuplicates() {
        List<Duplicate> sorted = new ArrayList<>(duplicates);

        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                Duplicate d1 = sorted.get(j);
                Duplicate d2 = sorted.get(j + 1);
                boolean needSwap = false;
                int typeCompare = d1.getType().compareTo(d2.getType());
                if (typeCompare > 0) {
                    needSwap = true;
                } else if (typeCompare == 0) {
                    if (d1.getIndex() > d2.getIndex()) {
                        needSwap = true;
                    } else if (d1.getIndex() == d2.getIndex()) {
                        if (d1.getValue() > d2.getValue()) {
                            needSwap = true;
                        }
                    }
                }
                if (needSwap) {
                    sorted.set(j, d2);
                    sorted.set(j + 1, d1);
                }
            }
        }
        return sorted;
    }
}
