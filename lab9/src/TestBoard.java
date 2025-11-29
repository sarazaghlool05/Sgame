public class TestBoard {
    public static void main(String[] args) {
        String file = "board.csv";
        String[] modes = {"0", "3", "27"};

        SodukoVerifier verifier = new SodukoVerifier();

        for (String mode : modes) {
            System.out.println("Mode " + mode + ":");
            try {
                ValidationResult result = verifier.validate(file, mode);
                ResultPrinting.printResult(result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("----------------------------------");
        }
    }
}