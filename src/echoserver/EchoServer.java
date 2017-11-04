import java.net.*;
import java.io.*;

public class EchoServer {
  public static void main(String[] args) {
    try {
      InputStream input = null;
      OutputStream output = null;
      ServerSocket sock = new ServerSocket(6013);
      Socket socket = null;

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
            output = new FileOutputStream("andy.txt");
            System.out.println("here2");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. ");
        }

        byte[] bytes = new byte[8192];

        int count =0;
        System.out.println("this is the count outside");

          System.out.println(count);
        while((count = input.read()) != -1) {
          System.out.println("this is the count");

            System.out.println(count);
          output.write(count);
          output.flush();
            System.out.println("here");
        }
        System.out.println("this is the count outsidebelow");

          System.out.println(count);
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
