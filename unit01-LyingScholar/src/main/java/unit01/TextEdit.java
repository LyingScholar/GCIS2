package unit01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//1.29
public class TextEdit {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a filename :");
        String filename = scnr.nextLine();
        try(FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw)){
            
            
            System.out.println("Enter text to save -- enter a blank line to quit.");
            while(true){
                String line = scnr.nextLine();
                if (line.equals("")){
                    break;
                } else{
                    pw.println(line);
                }
            }
            pw.flush();
            // pw.close();
            // fw.close();
        } catch(IOException ioe){
            System.err.println("An error occured: " + ioe.getMessage());
        }
        scnr.close();
    }
}
