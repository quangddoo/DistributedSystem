package client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public final static String SERVER_IP = "127.0.0.1";
	public final static int PORT = 8080;
	
	public static void main(String argv[]) throws IOException {
		Socket socket = null;
		try {
			socket = new Socket(SERVER_IP, PORT);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			String message = null;
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("ENTER ARRAY INPUT:");
			message = scanner.nextLine();
			out.println(message);
			
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			scanner.close();
		} catch (IOException e) {
			System.out.println("Client cannot connect to server!");
		}finally {
			socket.close();
		}
	}
}