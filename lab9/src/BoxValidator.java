import java.util.List;

public class BoxValidator implements Validator{
    private SudokuBoard board;
    private ValidationResult result;

    public BoxValidator(SudokuBoard board) {
        this.board = board;
        this.result = new ValidationResult();
    }

    public void validateBoxes() {
        for (int i = 0; i < 9; i++) {
            validateBox(i);
        }
    }

    public void validateBox(int boxIndex) {
        int[] box = board.getBox(boxIndex);
        List<Duplicate> duplicates = DuplicateDetector.findDuplicates(box, "BOX", boxIndex);

        for (Duplicate dup : duplicates) {
            result.addDuplicate(dup);
        }
    }

    @Override
    public ValidationResult validate(){
        return result;
    }

    @Override
    public void performValidation() {
        validateBoxes();
    }
}