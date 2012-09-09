package robotic.arm;

import java.io.*;
import java.net.*;
import java.util.*;

import com.robotic.arm.Command;

public class RoboticArmServer extends Thread{
	
	public static final int DEFAULT_SPEED = 75;
	
	private ServerSocket socket;
	private MotionTimer task;
	
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


	public RoboticArmServer(int port) throws Exception {
		socket = new ServerSocket(port);
		System.out.println("Server listening on port " + port);
	    this.start();
	}
	
	public void run()	{
		while(true) {
			try {
				System.out.println("Waiting for connections.");
				Socket client = socket.accept();
		        System.out.println("Accepted a connection from: "+
		        		client.getInetAddress());
		        Connection c = new Connection(client);
		       } catch(Exception e) {}
			}
	}

	public class Connection extends Thread {
		private Socket client = null;
		private ObjectInputStream input = null;
		private ObjectOutputStream output = null;
		
		public Connection(Socket clientSocket) {
			client = clientSocket;
			try {
				input = new ObjectInputStream(client.getInputStream());
				output = new ObjectOutputStream(client.getOutputStream());
			} 
			catch(Exception e1) { 
				try {
					client.close();
				}	
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				return;
			}
			
			this.start();
		}
		
		public void run()	{
			while (true)
			{
				try	{
					System.out.println("Waiting for command");
					Command cmd = (Command) input.readObject();
					System.out.println("Command received");
					if (cmd.type == Command.Type.DISCONNECT)	{
						System.out.println("Command: Disconnect");
						break;
					}
					else if (cmd.type == Command.Type.MOTOR_START)	{
						if (cmd.motor != null)	{
							Motor motor = new Motor(cmd.motor.id, cmd.motor.direction);
							scheduleTask(motor, DEFAULT_SPEED);
							System.out.println("Command: Motor " + motor.id);
						}
					}
					else if (cmd.type == Command.Type.MOTOR_STOP)	{
						task.stop();
					}
					else	{
						System.err.println("Unrecognized command type");
					}
				}
				catch (Exception e)	{
					e.printStackTrace();
				}
			}//while
			
			try {
				input.close();
				output.close();
				client.close();
			} catch (IOException e) {

			}
		}
	}
	
}
