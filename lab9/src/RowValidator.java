import java.util.List;

public class RowValidator implements Validator{
    private SudokuBoard board;
    private ValidationResult result;

    public RowValidator(SudokuBoard board) {
        this.board = board;
        this.result = new ValidationResult();
    }

    public void validateRows() {
        for (int i = 0; i < 9; i++) {
            validateRow(i);
        }
    }

    public void validateRow(int rowIndex) {
        int[] row = board.getRow(rowIndex);
        List<Duplicate> duplicates = DuplicateDetector.findDuplicates(row, "ROW", rowIndex);

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
        validateRows();
    }

    @Override
    public void performValidation(int index) {
        validateRow(index);
    }
}