import java.io.*;
import java.net.*;

public class server{
  public static void main(String[] args) {
	  int port=10000;
    try {
    	
      ServerSocket ss = new ServerSocket(port);
      System.out.println("Le serveur est en attente");
      Socket soc = ss.accept();
      InputStreamReader reader=new InputStreamReader(soc.getInputStream());
      BufferedReader in = new BufferedReader(reader);
      PrintWriter out = new PrintWriter(soc.getOutputStream(),true);

      String clientRequest = in.readLine();
      if (clientRequest.contains("soir")) {
        out.println("bonjour ne contient pas soir");
        out.flush();
      } else {
        out.println("bonjour contient jour");
        out.flush();
      }
      System.out.println("adresses client:"+soc.getRemoteSocketAddress());
      System.out.println("mon adress:"+soc.getLocalAddress()+" "+soc.getLocalPort());
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}