package unit12.calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalculatorClient {

        public static void main(String[] args) {
            try {
                DatagramSocket sock = new DatagramSocket();
                InetAddress address = InetAddress.getByName("nitron.se.rit.edu");
                Scanner scanner = new Scanner(System.in);
                // Socket client = new Socket("localhost",54321);
                // byte[] buffer = new byte[12400];
                byte[] buffer;


                System.out.print("Enter math operation (or nothing to exit): ");

                while (true) {
                    String input = scanner.nextLine();
                    if (input.trim().isEmpty()) {//its just a isEmpty, i know we weren't taught this, just chill
                        break;
                    }
                    buffer = input.getBytes();
                    DatagramPacket outgoin = new DatagramPacket(buffer, buffer.length, address, 12400);
                    sock.send(outgoin);
        
                    DatagramPacket incomin = new DatagramPacket(buffer, buffer.length);
                    sock.receive(incomin);
                    String received = new String(incomin.getData(), 0, incomin.getLength());
                    System.out.println("Result: " + received);
                }
                sock.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    
}
