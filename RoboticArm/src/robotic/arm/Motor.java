package robotic.arm;

public class Motor {
	public int id;
	public enum Direction { FORWARD, BACKWARD };
	public Direction direction;
	
	public Motor(int id, Direction direction)	{
		this.id = id;
		this.direction = direction;
	}
	
	public byte[] getByteMessage()	{
		byte[] msg = new byte[2];
		msg[0] = (byte) (id + "").charAt(0);
		if (direction == Direction.FORWARD)
			msg[1] = 'f';
		else
			msg[1] = 'b';
		return msg;
	}
}
