package robotic.arm;

import java.util.Timer;
import java.util.TimerTask;

import robotic.arm.RoboticArm;

//Timer timer = new Timer();
//TimerTask task = new MyTimerTask();

public class MotionTimer extends TimerTask {
	
	public static final int durationConstant = 10;
	
	private Timer timer;
	private byte[] msg;
	private int duration = 0;
	
	public MotionTimer(Motor motor, int speedPercentage)
	{
		this.msg = motor.getByteMessage();
		if (speedPercentage >= 0 && speedPercentage <= 100)	{
			this.duration = 100 - speedPercentage;
		}
		else	{	// Improper percentage given, use a default
			duration = 25;
		}
		this.timer = new Timer();
	}
	
	public void start()	{
		System.out.println("Starting movement");
		timer.scheduleAtFixedRate(this, 0, durationConstant);
	}
	
	public void stop()	{
		System.out.println("Stopping movement");
		timer.cancel();
	}
	
    public void run() {
		RoboticArm.getInstance().connection.write(msg);
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}