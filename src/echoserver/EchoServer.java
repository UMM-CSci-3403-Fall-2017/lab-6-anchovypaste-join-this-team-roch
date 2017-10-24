package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) {
		try {
			ServerSocket sock = new ServerSocket(6013);

			while(true) {
				Socket client = sock.accept();

			}
		}
	}
}
