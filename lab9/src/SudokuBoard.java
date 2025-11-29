import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private final int[][] sudokuGrid = new int [9][9];

    public SudokuBoard(String filePath) throws IOException{
        load(filePath);
    }

    private void load(String filePath) throws IOException {
        List<String> errors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (row >= 9) {
                    errors.add("Board has more than 9 rows");
                    break;
                }

                String[] numbers = line.split(",");

                if (numbers.length != 9) {
                    errors.add("Row " + (row + 1) + " has " + numbers.length +
                            " columns, expected 9");
                    row++;
                    continue;
                }

                for (int column = 0; column < 9; column++) {
                    try {
                        int value = Integer.parseInt(numbers[column].trim());

                        if (value < 1 || value > 9) {
                            errors.add("Invalid value " + value + " at row " + (row + 1) +
                                    ", column " + (column + 1) + ". Values must be between 1 and 9");
                        } else {
                            sudokuGrid[row][column] = value;
                        }

                    } catch (NumberFormatException e) {
                        errors.add("Invalid number format '" + numbers[column].trim() +
                                "' at row " + (row + 1) + ", column " + (column + 1));
                    }
                }
                row++;
            }

            if (row < 9) {
                errors.add("Expected 9 rows, found " + row);
            }
            
            if (!errors.isEmpty()) {
                StringBuilder errorMessage = new StringBuilder("Invalid board format:\n");
                for (String error : errors) {
                    errorMessage.append("  - ").append(error).append("\n");
                }
                throw new IOException(errorMessage.toString());
            }
        }
    }

    public int getCell(int row, int column){
        return sudokuGrid[row][column];
    }

    public int[] getRow(int row){
        return sudokuGrid[row];
    }

    public int[] getColumn(int columnIndex){
        int[] column = new int[9];
        for(int row=0; row<9; row++){
            column[row] = sudokuGrid[row][columnIndex];
        }
        return column;
    }

    public int[] getBox(int boxIndex) {
        int[] box = new int[9];
        int rowStart = (boxIndex / 3) * 3;
        int columnStart = (boxIndex % 3) * 3;
        int i = 0;

        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int column = columnStart; column < columnStart + 3; column++) {
                box[i++] = sudokuGrid[row][column];
            }
        }
        return box;
    }
}
