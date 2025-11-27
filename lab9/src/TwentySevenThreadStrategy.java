import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class TwentySevenThreadStrategy implements VerificationStrategy{
    private final SudokuBoard board;
    private final ResultCollect FinalAnswer = new ResultCollect();

    public TwentySevenThreadStrategy(SudokuBoard board) {
        this.board = board;
    }
    public boolean verify(SudokuBoard board){
        List<Thread> threads= new ArrayList<>();
        for(int i=0;i<9;i++){
            RowValidator ValidatedRow= new RowValidator(board);
            ValidatedRow.validateRow(i);
            Thread R=new Thread(new VerificationTask(ValidatedRow));
            threads.add(R);
        }
        for(int i=0;i<9;i++){
            ColumnValidator ValidatedColumn=new ColumnValidator(board);
            ValidatedColumn.validateColumn(i);
            Thread C=new Thread(new VerificationTask(ValidatedColumn));
            threads.add(C);
        }
        for(int i=0;i<9;i++){
            BoxValidator ValidatedBox=new BoxValidator(board);
            ValidatedBox.validateBox(i);
            Thread B=new Thread(new VerificationTask(ValidatedBox));
            threads.add(B);
        }
        for(int i =0; i<threads.size();i++){
            Thread S=threads.get(i);
            S.start();
        }
        for(int i=0 ; i<threads.size();i++){
            try {
                Thread S = threads.get(i);
                S.join();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }

        }
        ValidationResult Solution=FinalAnswer.combined();
        return Solution.isValid();
    }
    @Override
    public List<Duplicate> returnDuplicates(){
      return FinalAnswer.combined().getSortedDuplicates();
    }
}
