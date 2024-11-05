package unit12.calculator;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

public class CalculatorServer {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(12400);
            //its the last week, please let me write my lists in one line
            List<BinaryOperation> operations = List.of(new Addition(), 
                new Subtraction(), new Multiplication(), new Division(), 
                new FloorDivision(), new Exponent());
            Calculator calculator = new Calculator(operations);
            byte[] buffer = new byte[1024];
            String result;
            while (true) {
                try {
                    DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
                    socket.receive(incoming);
    
                    String received = new String(incoming.getData(), 0, incoming.getLength());
                    String[] tokens = received.strip().split(" ");
                    
                    float operand1 = Float.parseFloat(tokens[0]);
                    float operand2 = Float.parseFloat(tokens[2]);
                    result = String.valueOf(calculator.calculate(tokens[1], operand1, operand2));
                    
                    InetAddress address = incoming.getAddress();
                    int port = incoming.getPort();
                    buffer = result.getBytes();
                    DatagramPacket outgoing = new DatagramPacket(buffer, buffer.length, address, port);
                    socket.send(outgoing);

                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
