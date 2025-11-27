import java.util.ArrayList;
import java.util.List;

public class ColumnValidator implements Validator{
    private SudokuBoard board;
    private ValidationResult result;

    public ColumnValidator(SudokuBoard board) {
        this.board = board;
        result = new ValidationResult();
    }

    public List<Duplicate> validateColumn(int columnIndex) {
        int[] column = board.getColumn(columnIndex);
        return DuplicateDetector.findDuplicates(column, "COL", columnIndex);
    }

    public void validateAllColumns() {
        List<Duplicate> allDuplicates = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            allDuplicates.addAll(validateColumn(i));
            for(int j = 0; j < validateColumn(i).size(); j++){
                result.addDuplicate(validateColumn(i).get(j));
            }
        }
    }

    @Override
    public ValidationResult validate(){
        return result;
    }
}