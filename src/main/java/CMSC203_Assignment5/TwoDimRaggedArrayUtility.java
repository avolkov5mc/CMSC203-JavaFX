package CMSC203_Assignment5;

/*
Class: CMSC203 CRN 30339
Program: Assignment #5
Instructor: Grigoriy Grinberg
Summary of Description: Calculates holiday bonuses from a two dimensional ragged array of doubles
Due Date: 4/15/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Alexei Volkov
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    private static final int MAX_ROW = 10;
    private static final int MAX_COL = 10;

    public static double getAverage(double[][] data){
        int totalNoElements = getTotalNoElements(data);
        double total = getTotal(data);
        return total / totalNoElements;
    }

    /**
     * Helper method to get the total number of elements in the matrix.
     * @param data The matrix.
     * @return The number of elements.
     */
    private static int getTotalNoElements(double[][] data){
        int total = 0;
        for(int row = 0; row < data.length; row++){
            // add length of each row to the total.
            total += data[row].length;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col){
        double sum = 0.0;
        for(int row = 0; row < data.length; row++){
            // Ignore rows that don't have this col.
            if(data[row].length > col){
                sum += data[row][col];
            }
        }
        return sum;
    }

    public static double getHighestInArray(double[][] data){
        double highestValue = data[0][0];
        for(int row = 0; row < data.length; row++){
            double value = getHighestInRow(data, row);
            if(value > highestValue){
                highestValue = value;
            }
        }
        return highestValue;
    }

    public static double getHighestInColumn(double[][] data, int col){
        return data[getHighestInColumnIndex(data, col)][col];
    }

    public static int getHighestInColumnIndex(double[][] data, int col){
        int highestRowIndex = -1;
        for(int row = 0; row < data.length; row++){
            // If the array has a value at this column
            if(data[row].length > col){
                // Check if the highest row is unset to avoid edge cases.
                // Otherwise, check if this value is greater than existing highest val
                if(highestRowIndex == -1 || data[row][col] > data[highestRowIndex][col]){
                    highestRowIndex = row;
                }
            }
        }
        return highestRowIndex;
    }

    public static double getHighestInRow(double[][] data, int row){
        return data[row][getHighestInRowIndex(data, row)];
    }

    public static int getHighestInRowIndex(double[][] data, int row){
        double[] array = data[row];
        int highestColIndex = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > array[highestColIndex]){
                highestColIndex = i;
            }
        }
        return highestColIndex;
    }

    public static double getLowestInArray(double[][] data){
        double lowestValue = data[0][0];
        for(int row = 0; row < data.length; row++){
            double value = getLowestInRow(data, row);
            if(value < lowestValue){
                lowestValue = value;
            }
        }
        return lowestValue;
    }

    public static double getLowestInColumn(double[][] data, int col){
        return data[getLowestInColumnIndex(data, col)][col];
    }

    public static int getLowestInColumnIndex(double[][] data, int col){
        int lowestRowIndex = -1;
        for(int row = 0; row < data.length; row++){
            // If the array has a value at this column
            if(data[row].length > col){
                // Check if the lowest row is unset to avoid edge cases.
                // Otherwise, check if this value is lower than existing highest val
                if(lowestRowIndex == -1 || data[row][col] < data[lowestRowIndex][col]){
                    lowestRowIndex = row;
                }
            }
        }
        return lowestRowIndex;
    }

    public static double getLowestInRow(double[][] data, int row){
        return data[row][getLowestInRowIndex(data, row)];
    }

    public static int getLowestInRowIndex(double[][] data, int row){
        double[] array = data[row];
        int lowestColIndex = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] < array[lowestColIndex]){
                lowestColIndex = i;
            }
        }
        return lowestColIndex;
    }

    public static double getRowTotal(double[][] data, int row){
        double[] array = data[row];
        double sum = 0.0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    public static double getTotal(double[][] data){
        double sum = 0.0;
        for(int row = 0; row < data.length; row++){
            sum += getRowTotal(data, row);
        }
        return sum;
    }

    public static double[][] readFile(File file) throws FileNotFoundException {
        // Create a temporary array of max size.
        String[][] temp = new String[MAX_ROW][MAX_COL];

        // Fill the temp array with values from the file.
        Scanner fileScanner = new Scanner(file);
        int currLineIndex = 0;
        while(fileScanner.hasNextLine()){
            // Get the line from file, and separate by spaces.
            String line = fileScanner.nextLine();
            String[] values = line.split(" ");
            // Fill the row with the space-separated values from the file.
            for(int i = 0; i < values.length; i++){
                temp[currLineIndex][i] = values[i];
            }
            currLineIndex++;
        }
        // Create a new double matrix, with same no. rows as the file had.
        double[][] toReturn = new double[currLineIndex][];

        // Figure out how many columns each row has.
        for(int row = 0; row < toReturn.length; row++){
            // Keep incrementing lastIndex until it reaches an empty value.
            int lastIndex = 0;
            while(temp[row][lastIndex] != null){
                lastIndex++;
            }
            // Build the new row of doubles to use
            toReturn[row] = new double[lastIndex+1];
            for(int col = 0; col < lastIndex; col++){
                // Access the data from the String matrix, convert to a double and save.
                toReturn[row][col] = Double.parseDouble(temp[row][col]);
            }
        }
        return toReturn;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(outputFile);
        for(int row = 0; row < data.length; row++){
            for(int col = 0; col < data[row].length; col++){
                // Print the data, separated by spaces.
                out.print(data[row][col] + " ");
            }
            // Only add newline if this isn't the last row.
            if(row != data.length-1){
                out.println();
            }
            out.flush();
        }
        out.close();
    }
}
