import java.util.ArrayList;
import java.util.List;

public class ResultCollect {
    private List<Duplicate> FoundDups=new ArrayList<>();
    public synchronized void addDuplicates(List<Duplicate> duplicates) {
        for (int i = 0; i < duplicates.size(); i++) {
            FoundDups.add(duplicates.get(i));
        }
    }
    public ValidationResult combined(){
        ValidationResult result=new ValidationResult();
        for(int i =0; i<FoundDups.size();i++){
            result.addDuplicate(FoundDups.get(i));
        }
        return  result;
    }
}
