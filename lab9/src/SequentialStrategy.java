import java.util.List;

public class SequentialStrategy implements VerificationStrategy{
    private final SudokuBoard board;
    private ValidationResult result;

    public SequentialStrategy(SudokuBoard board){
        this.board = board;
        result = new ValidationResult();
    }

    @Override
    public boolean verify(SudokuBoard board){
        RowValidator rowValidator = new RowValidator(board);
        rowValidator.validateAllRows();
        ValidationResult rowResult = rowValidator.validate();

        ColumnValidator columnValidator = new ColumnValidator(board);
        columnValidator.validateAllColumns();
        ValidationResult colResult = columnValidator.validate();

        BoxValidator boxValidator = new BoxValidator(board);
        boxValidator.validateAllBoxes();
        ValidationResult boxResult = boxValidator.validate();

        if(rowResult.isValid() && colResult.isValid() && boxResult.isValid()){
            result.setIsValid(true);
        }
        else{
            result.setIsValid(false);
        }

        return result.isValid();
    }

    @Override
    public List<Duplicate> returnDuplicates(){
        return result.getSortedDuplicates();
    }

}
