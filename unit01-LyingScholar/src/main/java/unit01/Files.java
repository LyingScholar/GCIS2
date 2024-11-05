package unit01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//1.26
public class Files {
    public static void info(String filename){
        File file = new File(filename);
        System.out.println("filename" + file.getName());
        System.out.println("abs path" + file.getAbsolutePath());
        System.out.println("file exists" + file.exists());
        if (file.exists()){
            System.out.println("This file exists - ");
            System.out.println("file elngth" + file.length());
        }else{
            System.out.println("the file does not exist");
        }
        System.out.println(file.exists());
    }
    //1.27
    //1.28 add throws
    public static void printFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
        fr.close();
    }
    public static void main(String[] args) {
        // info("src/main/java/unit01/Basics.java");
        // System.out.println();
        // info("src/main/java/unit01/Basics.java");
        // System.out.println();
        // info("unit01-LyingScholar/data/alice.txt");
        // System.out.println();
        try{
            printFile("unit01-LyingScholar/data/alice.txt");
        } catch(IOException ioe){
            System.err.println("There was an exception processing the file.");
        }

    }


}
