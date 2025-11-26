public class Validator {
    protected SudokuBoard board;

    public Validator(SudokuBoard board){
        this.board =  board;
    }
    public abstract ValidationResult validate();
}