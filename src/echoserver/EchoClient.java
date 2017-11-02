import java.net.*;
import java.io.*;

public class EchoClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 6013);
      InputStream input;
      OutputStream output;

      File file = new File(args[0]);

      byte[] bytes = new byte[16 * 1024];
      output = socket.getOutputStream();
      input = socket.getInputStream();

      int count;
        while ((count = input.read(bytes)) > 0) {
        	output.write(bytes, 0, count);
        }

      input.close();
      output.close();
      socket.close();

    } catch (IOException ioe) {
      System.out.println("We caught an exception");
      System.err.println(ioe);
    }
  }
}
