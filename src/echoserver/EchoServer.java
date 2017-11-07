package echoserver;
import java.net.*;
import java.io.*;

  public class EchoServer {
    public static void main(String[] args) {
      try {
        InputStream input = null;
        OutputStream output = null;
        ServerSocket sock = new ServerSocket(6013);
        Socket socket = null;

        while (true) {
          System.out.println("Got a request!");
          try {
              socket = sock.accept();
          } catch (IOException ex)
          {
              System.out.println("Can't accept client connection. ");
          }

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

          int count =0;
          //Reading in file until input.read returns -1
          while((count = input.read()) != -1) {
            output.write(count);
          }
          
          //Flushes the output stream and forces any buffered output bytes to be written out.
          output.flush();
          input.close();
          output.close();
          socket.close();
        }

      } catch (IOException ioe) {
        System.err.println(ioe);
      }
    }
  }
