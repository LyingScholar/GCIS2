package unit12.activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTime {
    public static void main(String[] args) {
        System.out.println();
        try{
            Socket client = new Socket("time.nist.gov",13);
            InputStream in = client.getInputStream();
            Scanner scanner = new Scanner(in);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
            client.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println();
    }
}
