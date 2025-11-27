import java.util.List;

public class SequentialStrategy implements VerificationStrategy, Validator{
    private final SudokuBoard board;
    private ValidationResult result;

    public SequentialStrategy(SudokuBoard board){
        this.board = board;
        result = new ValidationResult();
    }

    @Override
    public boolean verify(SudokuBoard board){
        RowValidator rowValidator = new RowValidator(board);
        List<Duplicate> rowDuplicates = rowValidator.validateAllRows();
        for(int i = 0; i < rowDuplicates.size(); i++){
            result.addDuplicate(rowDuplicates.get(i));
        }

        ColumnValidator columnValidator = new ColumnValidator(board);
        List<Duplicate> columnDuplicates = columnValidator.validateAllColumns();
        for(int i = 0; i < columnDuplicates.size(); i++){
            result.addDuplicate(columnDuplicates.get(i));
        }

        BoxValidator boxValidator = new BoxValidator(board);
        List<Duplicate> boxDuplicates = boxValidator.validateAllBoxes();
        for(int i = 0; i < boxDuplicates.size(); i++){
            result.addDuplicate(boxDuplicates.get(i));
        }
        return result.isValid();
    }

    @Override
    public List<Duplicate> returnDuplicates(){
        return result.getSortedDuplicates();
    }

    @Override
    public ValidationResult validate(){
        return result;
    }
}
