public class ThreeThreadStrategy implements Validator, VerificationStrategy{
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
        VerificationTask task = new VerificationTask(this);
        Thread rowThread = new Thread(task);
        Thread colThread = new Thread(task);
        Thread boxThread = new Thread(task);


    }
}
