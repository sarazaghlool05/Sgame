import java.util.List;

public class SequentialStrategy implements VerificationStrategy{
    private ValidationResult result;

    public SequentialStrategy(){
        result = new ValidationResult();
    }

    @Override
    public boolean verify(SudokuBoard board){
        RowValidator rowValidator = new RowValidator(board);
        rowValidator.validateRows();
        ValidationResult rowResult = rowValidator.validate();

        ColumnValidator columnValidator = new ColumnValidator(board);
        columnValidator.validateColumns();
        ValidationResult colResult = columnValidator.validate();

        BoxValidator boxValidator = new BoxValidator(board);
        boxValidator.validateBoxes();
        ValidationResult boxResult = boxValidator.validate();

        for(int i = 0; i < rowResult.getDuplicates().size(); i++){
            result.addDuplicate(rowResult.getDuplicates().get(i));
        }

        for(int i = 0; i < colResult.getDuplicates().size(); i++){
            result.addDuplicate(colResult.getDuplicates().get(i));
        }

        for(int i = 0; i < boxResult.getDuplicates().size(); i++){
            result.addDuplicate(boxResult.getDuplicates().get(i));
        }

        return result.isValid();
    }

    @Override
    public List<Duplicate> returnDuplicates(){
        return result.getSortedDuplicates();
    }

}
