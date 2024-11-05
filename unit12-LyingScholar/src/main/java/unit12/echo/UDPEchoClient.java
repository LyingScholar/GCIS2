package unit12.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) {
        System.out.println();

        try{
            DatagramSocket sock = new DatagramSocket();

            String message = "this is a udp message";
            System.out.println("Sending: " + message);

            DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(),InetAddress.getByName("localhost"),54321);
            sock.send(outgoing);

            byte[] buffer = new byte[1024];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            sock.receive(incoming);
            message = new String(incoming.getData(),0,incoming.getLength());
            System.out.println("Recieved: " + message);

            sock.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println();
    }
}
