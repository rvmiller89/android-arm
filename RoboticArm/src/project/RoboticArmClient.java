package project;

import java.net.*;
import java.io.*;
import java.util.*;

public class RoboticArmClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Socket socket = null;
        PrintWriter out = null;

        try {
            socket = new Socket("localhost", 1337);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O");
            System.exit(1);
        }

		Scanner keyboard = new Scanner(System.in);
		String userInput;
	
		while (true) {
			userInput = keyboard.nextLine();
			System.out.println("echo: " + userInput);
		    out.println(userInput);

		    if (userInput.equals("disconnect"))
		    	break;
		}
	
		out.close();
		socket.close();

	}

}
