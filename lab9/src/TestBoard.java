public class TestBoard {
    public static void main(String[] args) {
        String file = "Board.csv";
        String[] modes = new String[]{"0", "3", "27"};
        for (String mode : modes) {
            System.out.println("Mode " + mode + ":");
            try {
                SudokuBoard board = new SudokuBoard(file);
                VerificationStrategy strategy = StrategyFactory.createStrategy(board,mode);
                strategy.verify(board);
                ValidationResult result = new ValidationResult();
                ResultPrinting.printResult(result);
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
