public class SodukoVerifier {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java-jar <app-name>.jar<.csv filepath> <mode>");
            return;
        }
        String filePath = args[0];
       String mode = args[1];

        if (!(mode.equals("0")) && !mode.equals("3") && !mode.equals("27")) {
            System.out.println("Invalid mode. Choose 0, 3, or 27.");
            return;
        }
        try {

            SudokuBoard board = new SudokuBoard(filePath);
            VerificationStrategy strategy = StrategyFactory.createStrategy(board,mode);
            strategy.verify(board);
            ValidationResult result = new ValidationResult();
            ResultPrinting.printResult(result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
