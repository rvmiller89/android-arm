package robotic.arm;


/**
 * 
 * @author rvmiller89
 *
 */
public class RoboticArm {
	
	private static RoboticArm instance = null;
	public SerialConnection connection;

	private RoboticArm()
	{
		connection = new SerialConnection();
	}
	
	public static RoboticArm getInstance()
	{
		if (instance == null)
			instance = new RoboticArm();

		return instance;
	}

	public static void main(String[] args) throws InterruptedException {
		instance = new RoboticArm();
		RoboticArmInterface face = new RoboticArmInterface();
		face.open();

	}

}
