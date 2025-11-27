import java.util.List;

public class RowValidator {
    private SudokuBoard board;
    private ValidationResult result;

    public RowValidator(SudokuBoard board, ValidationResult result) {
        this.board = board;
        this.result = result;
    }

    public void validateRows() {
        for (int i = 0; i < 9; i++) {
            validateRow(i);
        }
    }

    public void validateRow(int rowIndex) {
        int[] row = board.getRow(rowIndex);
        List<Duplicate> duplicates = Duplicate.checkForDuplicates(row, "ROW", rowIndex);

        for (Duplicate dup : duplicates) {
            result.addDuplicate(dup);
        }
    }
}
