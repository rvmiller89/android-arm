package robotic.arm;

public class Motor {
	public int id;
	public int direction;
	public static final int FORWARD = 0;
	public static final int BACKWARD = 1;
	
	public Motor(int id, int direction)	{
		this.id = id;
		this.direction = direction;
	}
	
	public byte[] getByteMessage()	{
		byte[] msg = new byte[2];
		msg[0] = (byte) (id + "").charAt(0);
		if (direction == FORWARD)
			msg[1] = 'f';
		else
			msg[1] = 'b';
		return msg;
	}
}
