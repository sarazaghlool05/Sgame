import java.util.ArrayList;
import java.util.List;

public class ZeroThreadStrategy implements VerificationStrategy {
    private SudokuBoard board;
    private List<Duplicate> allDuplicates;

    public ZeroThreadStrategy(SudokuBoard board) {
        this.board = board;
        this.allDuplicates = new ArrayList<>();
    }

    @Override
    public boolean verify(SudokuBoard board) {
        allDuplicates.clear();

        // Create validators - they create their own internal results
        RowValidator rowValidator = new RowValidator(board);
        ColumnValidator columnValidator = new ColumnValidator(board);
        BoxValidator boxValidator = new BoxValidator(board);

        // Perform validations
        rowValidator.performValidation();
        columnValidator.performValidation();
        boxValidator.performValidation();

        // Collect all duplicates from each validator
        allDuplicates.addAll(rowValidator.validate().getDuplicates());
        allDuplicates.addAll(columnValidator.validate().getDuplicates());
        allDuplicates.addAll(boxValidator.validate().getDuplicates());

        // Return true if no duplicates found (valid board)
        return allDuplicates.isEmpty();
    }

    @Override
    public List<Duplicate> returnDuplicates() {
        return new ArrayList<>(allDuplicates);
    }
}