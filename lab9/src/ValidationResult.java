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

    public synchronized void merge(ValidationResult other) {
        for (Duplicate dup : other.getDuplicates()) {
            addDuplicate(dup);
        }
    }

    public synchronized List<Duplicate> getSortedDuplicates() {
        List<Duplicate> sorted = new ArrayList<>(duplicates);
        Collections.sort(sorted);
        return sorted;
    }
}
