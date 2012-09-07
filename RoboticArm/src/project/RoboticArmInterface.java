package project;

import java.util.Timer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Spinner;

import project.Motor.Direction;

public class RoboticArmInterface {
	private Spinner speedSelector;
	private MotionTimer task;
	protected Shell shlRoboticArmInterface;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlRoboticArmInterface.open();
		shlRoboticArmInterface.layout();
		while (!shlRoboticArmInterface.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Schedules an event to move the motor according to the byte-encoded
	 * message
	 * 
	 * @param msg
	 */
	public void scheduleTask(Motor motor) {
		task = new MotionTimer(motor, Integer.parseInt(speedSelector.getText()));
		task.start();
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlRoboticArmInterface = new Shell();
		shlRoboticArmInterface.setSize(500, 460);
		shlRoboticArmInterface.setText("Robotic Arm Interface");

		Button motor4Up = new Button(shlRoboticArmInterface, SWT.NONE);
		motor4Up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				scheduleTask(new Motor(4, Direction.FORWARD));
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				task.stop();
			}
		});

		motor4Up.setBounds(106, 21, 53, 30);
		motor4Up.setText("Up");

		Button motor4Down = new Button(shlRoboticArmInterface, SWT.NONE);
		motor4Down.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				scheduleTask(new Motor(4, Direction.BACKWARD));
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				task.stop();
			}
		});

		motor4Down.setText("Down");
		motor4Down.setBounds(155, 21, 70, 30);

		Button btnOpen = new Button(shlRoboticArmInterface, SWT.NONE);
		btnOpen.setText("Open");
		btnOpen.setBounds(10, 72, 70, 30);

		Button btnClose = new Button(shlRoboticArmInterface, SWT.NONE);
		btnClose.setText("Close");
		btnClose.setBounds(10, 95, 70, 30);

		Button motor3Up = new Button(shlRoboticArmInterface, SWT.NONE);
		motor3Up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				scheduleTask(new Motor(3, Direction.FORWARD));
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				task.stop();
			}
		});

		motor3Up.setText("Up");
		motor3Up.setBounds(333, 50, 53, 30);

		Button motor3Down = new Button(shlRoboticArmInterface, SWT.NONE);
		motor3Down.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				scheduleTask(new Motor(3, Direction.BACKWARD));
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				task.stop();
			}
		});

		motor3Down.setText("Down");
		motor3Down.setBounds(365, 72, 70, 30);

		Button motor2Up = new Button(shlRoboticArmInterface, SWT.NONE);
		motor2Up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				scheduleTask(new Motor(2, Direction.FORWARD));
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				task.stop();
			}
		});

		motor2Up.setText("Up");
		motor2Up.setBounds(145, 198, 53, 30);

		Button motor2Down = new Button(shlRoboticArmInterface, SWT.NONE);
		motor2Down.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				scheduleTask(new Motor(2, Direction.BACKWARD));
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				task.stop();
			}
		});

		motor2Down.setText("Down");
		motor2Down.setBounds(136, 220, 70, 30);

		Button motor1Left = new Button(shlRoboticArmInterface, SWT.NONE);

		motor1Left.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				scheduleTask(new Motor(1, Direction.BACKWARD));
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				task.stop();
			}
		});

		motor1Left.setText("Left");
		motor1Left.setBounds(191, 368, 53, 30);

		Button motor1Right = new Button(shlRoboticArmInterface, SWT.NONE);
		motor1Right.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				scheduleTask(new Motor(1, Direction.FORWARD));
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				task.stop();
			}
		});

		motor1Right.setText("Right");
		motor1Right.setBounds(240, 368, 70, 30);

		Label lblNewLabel = new Label(shlRoboticArmInterface, SWT.NONE);
		lblNewLabel.setBounds(201, 400, 59, 14);
		lblNewLabel.setText("Motor 1");

		Label lblMotor = new Label(shlRoboticArmInterface, SWT.NONE);
		lblMotor.setText("Motor 2");
		lblMotor.setBounds(145, 185, 59, 14);

		Label lblMotor_1 = new Label(shlRoboticArmInterface, SWT.NONE);
		lblMotor_1.setText("Motor 3");
		lblMotor_1.setBounds(392, 50, 59, 14);

		Label label = new Label(shlRoboticArmInterface, SWT.NONE);
		label.setImage(SWTResourceManager.getImage("res/arm_transparent.png"));
		label.setBounds(21, 48, 450, 314);

		Label lblMotor_2 = new Label(shlRoboticArmInterface, SWT.NONE);
		lblMotor_2.setText("Motor 4");
		lblMotor_2.setBounds(136, 10, 59, 14);

		speedSelector = new Spinner(shlRoboticArmInterface, SWT.BORDER);
		speedSelector.setTextLimit(3);
		speedSelector.setSelection(75);
		speedSelector.setPageIncrement(1);
		speedSelector.setBounds(420, 395, 51, 22);

		Label lblSpeed = new Label(shlRoboticArmInterface, SWT.NONE);
		lblSpeed.setBounds(365, 400, 51, 14);
		lblSpeed.setText("Speed:");

	}
}