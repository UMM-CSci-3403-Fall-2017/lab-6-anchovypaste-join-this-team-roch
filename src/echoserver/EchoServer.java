import java.net.*;
import java.io.*;

public class EchoServer {
  public static void main(String[] args) {
    try {
      Socket socket = null;
      InputStream input = null;
      OutputStream output = null;
      ServerSocket sock = new ServerSocket(6013);

      //Code gotten from stackOverFlow userName = Pankaj
      while (true) {
        System.out.println("Got a request!");
        try {
            socket = sock.accept();
        } catch (IOException ex) {
            System.out.println("Can't accept client connection. ");
        }

        try {
            input = socket.getInputStream();
            System.out.println(input);
            System.out.println("here");
        } catch (IOException ex) {
            System.out.println("Can't get socket input stream. ");
        }

        try {
            output = new FileOutputStream("M:\\test2.xml");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. ");
        }

        byte[] bytes = new byte[16*1024];

        int count;
        while ((count = input.read(bytes)) > 0) {
            output.write(bytes, 0, count);
        }

        output.close();
        input.close();
        socket.close();
        sock.close();
      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}
