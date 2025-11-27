import java.util.ArrayList;
import java.util.List;

public class BoxValidator implements Validator {
    private SudokuBoard board;
    private ValidationResult result;

    public BoxValidator(SudokuBoard board) {
        this.board = board;
        result = new ValidationResult();
    }

    public List<Duplicate> validateBox(int boxIndex) {
        int[] box = board.getBox(boxIndex);
        return DuplicateDetector.findDuplicates(box, "BOX", boxIndex);
    }

    public void validateAllBoxes() {
        List<Duplicate> allDuplicates = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            allDuplicates.addAll(validateBox(i));
            for(int j = 0; j < validateBox(i).size(); j++){
                result.addDuplicate(validateBox(i).get(j));
            }
        }
    }

    @Override
    public ValidationResult validate(){
        return result;
    }
}