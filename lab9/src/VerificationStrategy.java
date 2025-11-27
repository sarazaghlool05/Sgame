import java.util.List;

public interface VerificationStrategy {
    boolean verify(SudokuBoard board);
    List<Duplicate> returnDuplicates();
}
