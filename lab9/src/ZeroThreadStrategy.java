import java.util.ArrayList;
import java.util.List;

public class ZeroThreadStrategy implements VerificationStrategy {
    private List<Duplicate> allDuplicates;

    public ZeroThreadStrategy() {
        this.allDuplicates = new ArrayList<>();
    }

    @Override
    public boolean verify(SudokuBoard board) {
        allDuplicates.clear();

        RowValidator rowValidator = new RowValidator(board);
        ColumnValidator columnValidator = new ColumnValidator(board);
        BoxValidator boxValidator = new BoxValidator(board);

        rowValidator.performValidation();
        columnValidator.performValidation();
        boxValidator.performValidation();

        allDuplicates.addAll(rowValidator.validate().getDuplicates());
        allDuplicates.addAll(columnValidator.validate().getDuplicates());
        allDuplicates.addAll(boxValidator.validate().getDuplicates());
        
        return allDuplicates.isEmpty();
    }

    @Override
    public List<Duplicate> returnDuplicates() {
        return new ArrayList<>(allDuplicates);
    }
}