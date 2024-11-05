package unit02;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Practise01 {
    
    public static String arrayToString(int[] array) {
        if (array.length == 0) {
            return "[]";
        }
        String result = new String("[" + array[0]);

        for (int i = 1; i < array.length; i++) {
            result = result + ", "+ (array[i]);
        }

        result = result + "]";
        return result.toString();
    }

    public static int printLines(String filename, char letter) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().startsWith(String.valueOf(letter).toLowerCase())) {
                    // System.out.println(line);
                    lineCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
    }
    return lineCount;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        String arrayString = arrayToString(array);
        System.out.println(arrayString);


        String filename = "/Users/mukul/GCIS2/unit02-LyingScholar/data/alice.txt";
        char letter = 'y';
        int printedLines = printLines(filename, letter);
        System.out.println("Total lines printed: " + printedLines);
    }
}
