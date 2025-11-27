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
        List<Validator> validators=new ArrayList<>();
        for(int i=0;i<9;i++){
            RowValidator ValidatedRow= new RowValidator(board);
            validators.add(ValidatedRow);
            Thread R=new Thread(new VerificationTask(ValidatedRow,i));
            threads.add(R);
        }
        for(int i=0;i<9;i++){
            ColumnValidator ValidatedColumn=new ColumnValidator(board);
            validators.add(ValidatedColumn);
            Thread C=new Thread(new VerificationTask(ValidatedColumn,i));
            threads.add(C);
        }
        for(int i=0;i<9;i++){
            BoxValidator ValidatedBox=new BoxValidator(board);
            validators.add(ValidatedBox);
            Thread B=new Thread(new VerificationTask(ValidatedBox,i));
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
        for(int i=0 ; i<validators.size();i++){
            Validator v=validators.get(i);
            FinalAnswer.addDuplicates(v.validate().getDuplicates());

        }
        return FinalAnswer.combined().isValid();
    }
    @Override
    public List<Duplicate> returnDuplicates(){
      return FinalAnswer.combined().getSortedDuplicates();
    }

}
