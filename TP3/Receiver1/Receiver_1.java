import java.io.*;
import java.net.*;

public class Receiver_1 {

    public static void main(String[] args) {
        // Port to listen for incoming data
        int portNumber = 12345;
        // Name of file to save received data to
        String fileName = "received.txt";
        // Create a buffer for storing received data
        byte[] receiveBuffer = new byte[1024];

        try {
            // Open a multicast socket on the specified port
            MulticastSocket socket = new MulticastSocket(portNumber);
            // Join the multicast group
            InetAddress group = InetAddress.getByName("224.0.0.1");
            socket.joinGroup(group);

            // Create a file output stream for writing received data
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);

            // Receive packets until the end of the file is reached
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            int bytesRead = 0;
            while (true) {
                socket.receive(receivePacket);
                bytesRead = receivePacket.getLength();
                // Check for end of file
                if (bytesRead == -1) {
                    break;
                }
                // Write the received data to the file
                fileOutputStream.write(receivePacket.getData(), 0, bytesRead);
            }
            System.out.println("File received successfully.");
        } catch (IOException e) {
            System.err.println("Error receiving file: " + e.getMessage());
        }
    }

}
