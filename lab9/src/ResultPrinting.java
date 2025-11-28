import java.util.List;
public class ResultPrinting {

        public static void printResult(ValidationResult result) {
            if (result.isValid()) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
                List<Duplicate> duplicates = result.getSortedDuplicates();
                for (Duplicate d : duplicates) {
                    System.out.println(
                            d.getType() + " " + d.getIndex() + ", #" + d.getValue() + ", positions=" + d.getPositions()
                    );
                }
            }
        }
    }


