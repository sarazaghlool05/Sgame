import java.util.List;

public class ThreeThreadStrategy implements VerificationStrategy{
    private  SudokuBoard board;
    private RowValidator rowValidator;
    private ColumnValidator columnValidator;
    private  BoxValidator boxValidator;
    private  ValidationResult result;

    public  ThreeThreadStrategy(SudokuBoard board){
        this.board = board;
        rowValidator = new RowValidator(board);
        columnValidator = new ColumnValidator(board);
        boxValidator = new BoxValidator(board);
        result = new ValidationResult();
    }

    @Override
    public synchronized boolean verify(SudokuBoard board){
        VerificationTask rowTask = new VerificationTask(rowValidator);
        VerificationTask colTask = new VerificationTask(columnValidator);
        VerificationTask boxTask = new VerificationTask(boxValidator);

        Thread row = new Thread(rowTask);
        Thread col = new Thread(colTask);
        Thread box = new Thread(boxTask);

        row.setPriority(10);
        col.setPriority(5);
        box.setPriority(1);

        row.start();
        col.start();
        box.start();


        return result.isValid();
    }

    @Override
    public List<Duplicate> returnDuplicates(){
        return result.getSortedDuplicates();
    }
}
