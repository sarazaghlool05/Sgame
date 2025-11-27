import java.util.ArrayList;
import java.util.List;

public class ColumnValidator {
    private SudokuBoard board;

    public ColumnValidator(SudokuBoard board) {
        this.board = board;
    }

    public List<Duplicate> validateColumn(int columnIndex) {
        int[] column = board.getColumn(columnIndex);
        return DuplicateDetector.findDuplicates(column, "COL", columnIndex);
    }

    public List<Duplicate> validateAllColumns() {
        List<Duplicate> allDuplicates = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            allDuplicates.addAll(validateColumn(i));
        }
        return  allDuplicates;
    }
}