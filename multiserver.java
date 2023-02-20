import java.io.*;
import java.net.*;

public class multiserver {
  public static void main(String[] args) {
    int port = 10000;
    try {
      ServerSocket ss = new ServerSocket(port);
      System.out.println("Server is listening");
      while (true) {
        Socket soc = ss.accept();
        System.out.println("Accepted connection from " + soc.getRemoteSocketAddress());
        new ClientHandler(soc).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class ClientHandler extends Thread {
  private Socket socket;

  ClientHandler(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      InputStreamReader reader = new InputStreamReader(socket.getInputStream());
      BufferedReader in = new BufferedReader(reader);
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      String clientRequest = in.readLine();
      if (clientRequest.contains("soir")) {
        out.println("bonjour does not contain soir");
        out.flush();
      } else {
        out.println("bonjour contains soir");
        out.flush();
      }
      System.out.println("Client address: " + socket.getRemoteSocketAddress());
      System.out.println("My address: " + socket.getLocalAddress() + " " + socket.getLocalPort());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
