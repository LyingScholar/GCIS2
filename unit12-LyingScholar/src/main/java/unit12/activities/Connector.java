package unit12.activities;

import java.io.IOException;
import java.net.Socket;

public class Connector {
    public static void main(String[] args) {
        System.out.println();
        try{
            Socket sock1 = new Socket("www.google.com",80);
            Socket sock2 = new Socket("www.npr.org",443);
            Socket sock3 = new Socket("swec-123.rit.edu.com",33075);
            sock1.close();
            sock2.close();
            sock3.close();
            
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        System.out.println();
    }
}
