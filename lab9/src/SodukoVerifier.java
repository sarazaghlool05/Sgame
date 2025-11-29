import java.io.IOException;

public class SodukoVerifier {
    public ValidationResult validate(String filePath, String mode) throws IOException {
        SudokuBoard board = new SudokuBoard(filePath);
        VerificationStrategy strategy = StrategyFactory.createStrategy(board, mode);
        strategy.verify(board);
        ValidationResult result = new ValidationResult();
        for (Duplicate dup : strategy.returnDuplicates()) {
            result.addDuplicate(dup);
        }
        return result;
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java -jar <app-name>.jar <.csv filepath> <mode>");
            System.err.println("Modes: 0 (no threads), 3 (3 threads), 27 (27 threads)");
            System.exit(1);
        }

        String filePath = args[0];
        String mode = args[1];

        if (!mode.equals("0") && !mode.equals("3") && !mode.equals("27")) {
            System.err.println("Invalid mode: " + mode);
            System.err.println("Valid modes are: 0, 3, or 27");
            System.exit(1);
        }

        try {
            SodukoVerifier verifier = new SodukoVerifier();
            ValidationResult result = verifier.validate(filePath, mode);
            ResultPrinting.printResult(result);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}