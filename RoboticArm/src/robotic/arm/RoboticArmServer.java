package robotic.arm;

import java.io.*;
import java.net.*;
import java.util.*;

public class RoboticArmServer {
	
	private MotionTimer task;
	private ServerSocket s;
	private int port;
	
	/**
	 * Schedules an event to move the motor according to the byte-encoded
	 * message, contained in the Motor object
	 * 
	 * @param motor
	 */
	public void scheduleTask(Motor motor, int speed) {
		task = new MotionTimer(motor, speed);
		task.start();
	}
	
	/**
	 * Stops the execution of a motor task
	 * 
	 */
	public void stopTask() {
		task.stop();
	}


	public RoboticArmServer(int port) {
		
		this.port = port;

	}
	
	public boolean start()	{
		try
		{
			s = new ServerSocket(port);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
			
			
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try
				{
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
								String input = in.next();
								System.out.println("Recvd: " + input);
								if (input.trim().equals("disconnect"))
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
		});
	
		return true;
	}

}
