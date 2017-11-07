package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 6013);
      InputStream input = null;
      OutputStream output = null;
      //trying to get the InputStream
      try {
          input = socket.getInputStream();
      } catch (IOException ex) {
          System.out.println("Can't get socket input stream. ");
      }

      try {
          output = socket.getOutputStream();
      } catch (IOException ex) {
          System.out.println("Can't get socket output stream. ");
      }

      int count;
      //Reading in file until the System.in.read returns -1
      while((count = System.in.read()) != -1){
        output.write(count);
        System.out.write(input.read());
      }
      
      //Flushes the output stream and forces any buffered output bytes to be written out
      output.flush();
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
