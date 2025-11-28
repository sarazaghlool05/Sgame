import java.util.List;

public class ColumnValidator implements Validator{
    private SudokuBoard board;
    private ValidationResult result;

    public ColumnValidator(SudokuBoard board) {
        this.board = board;
        this.result = new ValidationResult();
    }

    public void validateColumns() {
        for (int i = 0; i < 9; i++) {
            validateColumn(i);
        }
    }

    public void validateColumn(int columnIndex) {
        int[] column = board.getColumn(columnIndex);
        List<Duplicate> duplicates = DuplicateDetector.findDuplicates(column, "COL", columnIndex);

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
        validateColumns();
    }

    @Override
    public void performValidation(int index) {
        validateColumn(index);  // ONE column
    }
}