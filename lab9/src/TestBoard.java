public class TestBoard {
    public static void main(String[] args) {
        String file = "board.csv";
        String[] modes = new String[]{"0", "3", "27"};

        for (String mode : modes) {
            System.out.println("Mode " + mode + ":");
            try {
                SudokuBoard board = new SudokuBoard(file);
                VerificationStrategy strategy = StrategyFactory.createStrategy(board, mode);
                boolean valid = strategy.verify(board);
                ValidationResult result = new ValidationResult();
                for (Duplicate d : strategy.returnDuplicates()) {
                    result.addDuplicate(d);
                }

                ResultPrinting.printResult(result);
                System.out.println("----------------------------------");
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
