package unit12.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) {
        System.out.println();

        try{
            DatagramSocket server = new DatagramSocket(54321);

            byte[] buffer = new byte[1024];
            DatagramPacket incoming = new DatagramPacket(buffer,buffer.length);
            server.receive(incoming);

            String message = new String(incoming.getData(),0,incoming.getLength());
            System.out.println("Recieved: "+message);

            String outMessage = message.toUpperCase();
            System.out.println("returning: "+ outMessage);
            System.out.println("to: " + incoming.getAddress()+ ":"+incoming.getPort());

            DatagramPacket outgoing = new DatagramPacket(outMessage.getBytes(),outMessage.length(), incoming.getAddress(), incoming.getPort());
            server.send(outgoing);

            server.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println();
    }
}
