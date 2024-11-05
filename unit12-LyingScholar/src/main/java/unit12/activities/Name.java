package unit12.activities;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Name {
    public static void main(String[] args) {
        System.out.println();
        try{
            Socket sock = new Socket("44.201.255.0",16788);
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            pw.println("Quartz");
            pw.flush();
            sock.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println();
    }
}
