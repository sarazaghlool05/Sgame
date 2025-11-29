import java.util.List;

public class ThreeThreadStrategy implements VerificationStrategy{
    private  ValidationResult result;

    public  ThreeThreadStrategy(){
        result = new ValidationResult();
    }

    @Override
    public boolean verify(SudokuBoard board){
        RowValidator rowValidator = new RowValidator(board);
        ColumnValidator columnValidator = new ColumnValidator(board);
        BoxValidator boxValidator = new BoxValidator(board);

        VerificationTask rowTask = new VerificationTask(rowValidator);
        VerificationTask colTask = new VerificationTask(columnValidator);
        VerificationTask boxTask = new VerificationTask(boxValidator);

        Thread row = new Thread(rowTask);
        Thread col = new Thread(colTask);
        Thread box = new Thread(boxTask);

        row.start();
        col.start();
        box.start();

        try{
            row.join();
            col.join();
            box.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("error in threading");
        }

        ValidationResult rowResult = rowValidator.validate();
        ValidationResult colResult = columnValidator.validate();
        ValidationResult boxResult = boxValidator.validate();

        mergeResult(rowResult);
        mergeResult(colResult);
        mergeResult(boxResult);

        return result.isValid();
    }

    @Override
    public List<Duplicate> returnDuplicates(){
        return result.getSortedDuplicates();
    }

    private void mergeResult(ValidationResult source) {
        for (Duplicate dup : source.getDuplicates()) {
            result.addDuplicate(dup);
        }
    }
}
