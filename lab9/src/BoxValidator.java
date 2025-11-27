import java.util.ArrayList;
import java.util.List;

public class BoxValidator {
    private SudokuBoard board;

    public BoxValidator(SudokuBoard board) {
        this.board = board;
    }

    public List<Duplicate> validateBox(int boxIndex) {
        int[] box = board.getBox(boxIndex);
        return DuplicateDetector.findDuplicates(box, "BOX", boxIndex);
    }

    public List<Duplicate> validateAllBoxes() {
        List<Duplicate> allDuplicates = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            allDuplicates.addAll(validateBox(i));
        }
        return allDuplicates;
    }
}