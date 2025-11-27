import java.util.ArrayList;
import java.util.List;

public class RowValidator {
    private SudokuBoard board;

    public RowValidator(SudokuBoard board) {
        this.board = board;
    }

    public List<Duplicate> validateRow(int rowIndex) {
        int[] row = board.getRow(rowIndex);
        return DuplicateDetector.findDuplicates(row, "ROW", rowIndex);
    }

    public List<Duplicate> validateAllRows() {
        List<Duplicate> allDuplicates = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            allDuplicates.addAll(validateRow(i));
        }
        return allDuplicates;
    }
}
