public class ZeroThreadStrategy implements Validator{
    private SudokuBoard board;

    public ZeroThreadStrategy(SudokuBoard board) {
        this.board = board;
    }

    @Override
    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        RowValidator rowValidator = new RowValidator(board, result);
        ColumnValidator columnValidator = new ColumnValidator(board, result);
        BoxValidator boxValidator = new BoxValidator(board, result);

        rowValidator.validateRows();
        columnValidator.validateColumns();
        boxValidator.validateBoxes();

        return result;
    }
}
