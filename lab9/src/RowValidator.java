import java.util.ArrayList;
import java.util.List;

public class RowValidator implements Validator{
    private SudokuBoard board;
    private ValidationResult result;

    public RowValidator(SudokuBoard board) {
        this.board = board;
        result = new ValidationResult();
    }

    public List<Duplicate> validateRow(int rowIndex) {
        int[] row = board.getRow(rowIndex);
        return DuplicateDetector.findDuplicates(row, "ROW", rowIndex);
    }

    public void validateAllRows() {
        List<Duplicate> allDuplicates = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            allDuplicates.addAll(validateRow(i));
            for(int j = 0; j < validateRow(i).size(); j++){
                result.addDuplicate(validateRow(i).get(j));
            }
        }
    }

    @Override
    public ValidationResult validate(){
        return result;
    }
}
