package com.robotic.arm;
import java.io.Serializable;

public class Command implements Serializable {
	
	public static enum Type	{ MOTOR_START, MOTOR_STOP, DISCONNECT };
	
	public Type type;
	public Motor motor;

	/**
	 * Create a new command object to send or receive
	 * @param type The type of command contained
	 */
	public Command(Type type, Motor motor) {
		this.type = type;
		this.motor = motor;
	}
	
	public static class Motor implements Serializable {
		public int id;
		public int direction;
		public static final int FORWARD = 0;
		public static final int BACKWARD = 1;
		
		public Motor(int id, int direction)	{
			this.id = id;
			this.direction = direction;
		}
	}

}
