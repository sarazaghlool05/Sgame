import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuBoard {
    private final int[][] sudokuGrid = new int [9][9];

    public SudokuBoard(String filePath) throws IOException{
        load(filePath);
    }

    private void load(String filePath) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int row = 0;

        while((line = br.readLine())!=null && row<9){
            String[] numbers = line.split(",");
            for(int column = 0; column<9; column ++){
                sudokuGrid[row][column] = Integer.parseInt(numbers[column].trim());
            }
            row++;
        }
        br.close();
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
