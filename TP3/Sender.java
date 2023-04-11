import java.io.*;
import java.net.*;

public class Sender {

    public static void main(String[] args) {
        // Hostname or IP address of the multicast group
        String hostName = "224.0.0.1";
        // Port number to send data to
        int portNumber = 12345;
        // Name of file to send
        String fileName = "test.txt";

        try (
            // Open a file input stream for reading the file to be sent
            FileInputStream fileInputStream = new FileInputStream(fileName);
            // Open a multicast socket on the specified port
            MulticastSocket socket = new MulticastSocket();
        ) {
            // Get the multicast group address
            InetAddress group = InetAddress.getByName(hostName);

            // Create a buffer for sending data
            byte[] sendBuffer = new byte[1024];

            // Send the file data in chunks
            int bytesRead = 0;
            while ((bytesRead = fileInputStream.read(sendBuffer)) != -1) {
                // Create a datagram packet for the current chunk of data
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, bytesRead, group, portNumber);
                // Send the packet to the multicast group
                socket.send(sendPacket);
            }
            System.out.println("File sent successfully.");
        } catch (IOException e) {
            System.err.println("Error sending file: " + e.getMessage());
        }
    }

}
