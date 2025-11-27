import java.util.List;

public class BoxValidator {
    private SudokuBoard board;
    private ValidationResult result;

    public BoxValidator(SudokuBoard board, ValidationResult result) {
        this.board = board;
        this.result = result;
    }

    public void validateBoxes() {
        for (int i = 0; i < 9; i++) {
            validateBox(i);
        }
    }

    public void validateBox(int boxIndex) {
        int[] box = board.getBox(boxIndex);
        List<Duplicate> duplicates = Duplicate.checkForDuplicates(box, "BOX", boxIndex);

        for (Duplicate dup : duplicates) {
            result.addDuplicate(dup);
        }
    }
}