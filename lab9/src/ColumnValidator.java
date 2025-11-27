import java.util.List;

public class ColumnValidator {
    private SudokuBoard board;
    private ValidationResult result;

    public ColumnValidator(SudokuBoard board, ValidationResult result) {
        this.board = board;
        this.result = result;
    }

    public void validateColumns() {
        for (int i = 0; i < 9; i++) {
            validateColumn(i);
        }
    }

    public void validateColumn(int columnIndex) {
        int[] column = board.getColumn(columnIndex);
        List<Duplicate> duplicates = Duplicate.checkForDuplicates(column, "COL", columnIndex);

        for (Duplicate dup : duplicates) {
            result.addDuplicate(dup);
        }
    }
}