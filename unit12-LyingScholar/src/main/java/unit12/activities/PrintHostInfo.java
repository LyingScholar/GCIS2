package unit12.activities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintHostInfo {
    public static void main(String[] args) {
        
        System.out.println();
        try{
            InetAddress host = InetAddress.getLocalHost();
            System.out.println("hostname: " + host.getHostName());
            System.out.println("address: " + host.getHostAddress());

        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }
        System.out.println();
    }
}
