import java.net.*;
import java.io.*;

public class EchoClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 6013);
      InputStream input;
      OutputStream output;

      //File file = new File("kylesaidtodothis.txt");

      output = socket.getOutputStream();
      input = socket.getInputStream();

      int count;
      while((count = System.in.read()) != -1){
        System.out.println(count);
        output.write(count);
        System.out.write(input.read());
        output.flush();
      }

      System.out.flush();
      input.close();
      output.close();
      socket.close();

    } catch (IOException ioe) {
      System.out.println("We caught an exception");
      System.err.println(ioe);
    }
  }
}
