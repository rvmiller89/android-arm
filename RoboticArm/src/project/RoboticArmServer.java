package project;

import java.io.*;
import java.net.*;
import java.util.*;

public class RoboticArmServer {


	public static void main(String[] args) {
		if (args.length != 1)
		{
			System.out.println("Usage: RoboticArmServer [port]");
			System.exit(0);
		}
		
		try
		{
			ServerSocket s = new ServerSocket(Integer.parseInt(args[0]));

			while (true)
			{
				// Wait for client connection
				Socket incoming = s.accept();
				
				try
				{
					InputStream inStream = incoming.getInputStream();
					
					Scanner in = new Scanner(inStream);
					
					System.out.println("Client Connected");
					
					while (true)
					{
						String line = in.nextLine();
						System.out.println("Recvd: " + line);
						if (line.trim().equals("disconnect"))
							break;
					}
				}
				finally
				{
					System.out.println("Client disconnected");
					incoming.close();
				}
				
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
