public class StrategyFactory {
    public static VerificationStrategy createStrategy(SudokuBoard board, String mode) {
        switch (mode) {
            case "0": return new ZeroThreadStrategy();
            case "3": return new ThreeThreadStrategy();
           case "27": return new TwentySevenThreadStrategy(board);
            default: throw new IllegalArgumentException("Invalid mode");
        }
    }
}
