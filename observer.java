import java.net.*;
import java.io.*;

public class observer {
  public static void main(String[] args) {
    int port = 10000;
    String host = "localhost";
    try {
      InetAddress adr = InetAddress.getByName(host);
      Socket socket = new Socket(adr, port);
      InputStreamReader reader = new InputStreamReader(socket.getInputStream());
      BufferedReader in = new BufferedReader(reader);
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

      String clientInput = console.readLine();
      out.println("bonjour " + clientInput);
      out.flush();

      String serverResponse = in.readLine();
      System.out.println("My client address: " + socket.getLocalAddress() + " " + socket.getLocalPort());
      System.out.println("Server address: " + socket.getInetAddress() + " " + socket.getPort());
      System.out.println("Server Response: " + serverResponse);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
