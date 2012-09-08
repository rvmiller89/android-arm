package robotic.arm;

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

import robotic.arm.Motor.Direction;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class RoboticArmInterface {
	private MotionTimer task;
	private Spinner speedSelector_1;
	protected Shell shlRoboticArmInterface;
	private Text textfieldPort;
	private Label lblServerStatus;

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
     * @param Motor
     */
    public void scheduleTask(Motor motor) {
    		try	{
	            task = new MotionTimer(motor, Integer.parseInt(speedSelector_1.getText()));
	            task.start();
    		}
    		catch (Exception e)	{
    	
    		}
    }

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlRoboticArmInterface = new Shell();
		shlRoboticArmInterface.setSize(507, 544);
		shlRoboticArmInterface.setText("Robotic Arm Interface");
		
		TabFolder tabFolder = new TabFolder(shlRoboticArmInterface, SWT.NONE);
		tabFolder.setBounds(10, 10, 487, 502);
		
		TabItem tbtmControl = new TabItem(tabFolder, SWT.NONE);
		tbtmControl.setText("Control");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmControl.setControl(composite);
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("Motor 4");
		label.setBounds(126, 10, 59, 14);
		
		Button button = new Button(composite, SWT.NONE);
		button.setText("Up");
		button.setBounds(96, 21, 53, 30);
		button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                    scheduleTask(new Motor(4, Direction.FORWARD));
            }

            @Override
            public void mouseUp(MouseEvent arg0) {
                    task.stop();
            }
		});
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setText("Down");
		button_1.setBounds(145, 21, 70, 30);
		button_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                    scheduleTask(new Motor(4, Direction.BACKWARD));
            }

            @Override
            public void mouseUp(MouseEvent arg0) {
                    task.stop();
            }
		});
		
		Button button_2 = new Button(composite, SWT.NONE);
		button_2.setText("Open");
		button_2.setBounds(0, 72, 70, 30);
		
		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setText("Close");
		button_3.setBounds(0, 95, 70, 30);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("Motor 2");
		label_1.setBounds(135, 185, 59, 14);
		
		Button button_4 = new Button(composite, SWT.NONE);
		button_4.setText("Up");
		button_4.setBounds(135, 198, 53, 30);
		button_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                    scheduleTask(new Motor(2, Direction.FORWARD));
            }

            @Override
            public void mouseUp(MouseEvent arg0) {
                    task.stop();
            }
		});
		
		Button button_5 = new Button(composite, SWT.NONE);
		button_5.setText("Down");
		button_5.setBounds(126, 220, 70, 30);
		button_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                    scheduleTask(new Motor(2, Direction.BACKWARD));
            }

            @Override
            public void mouseUp(MouseEvent arg0) {
                    task.stop();
            }
		});
		
		Button button_6 = new Button(composite, SWT.NONE);
		button_6.setText("Up");
		button_6.setBounds(323, 50, 53, 30);
		button_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                    scheduleTask(new Motor(3, Direction.FORWARD));
            }

            @Override
            public void mouseUp(MouseEvent arg0) {
                    task.stop();
            }
		});
		
		Button button_7 = new Button(composite, SWT.NONE);
		button_7.setText("Down");
		button_7.setBounds(355, 72, 70, 30);
		button_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                    scheduleTask(new Motor(3, Direction.BACKWARD));
            }

            @Override
            public void mouseUp(MouseEvent arg0) {
                    task.stop();
            }
		});
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setText("Motor 3");
		label_3.setBounds(382, 50, 59, 14);
		
		Button button_8 = new Button(composite, SWT.NONE);
		button_8.setText("Left");
		button_8.setBounds(181, 368, 53, 30);
		button_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                    scheduleTask(new Motor(1, Direction.BACKWARD));
            }

            @Override
            public void mouseUp(MouseEvent arg0) {
                    task.stop();
            }
		});
		
		Button button_9 = new Button(composite, SWT.NONE);
		button_9.setText("Right");
		button_9.setBounds(230, 368, 70, 30);
		button_9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                    scheduleTask(new Motor(1, Direction.FORWARD));
            }

            @Override
            public void mouseUp(MouseEvent arg0) {
                    task.stop();
            }
		});
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setText("Motor 1");
		label_4.setBounds(191, 400, 59, 14);
		
		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setText("Speed:");
		label_5.setBounds(355, 400, 51, 14);
		
		speedSelector_1 = new Spinner(composite, SWT.BORDER);
		speedSelector_1.setTextLimit(3);
		speedSelector_1.setSelection(75);
		speedSelector_1.setPageIncrement(1);
		speedSelector_1.setBounds(410, 395, 51, 22);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setImage(SWTResourceManager.getImage("res/arm_transparent.png"));
		label_2.setBounds(11, 48, 450, 314);
		
		TabItem tbtmServerConfiguration = new TabItem(tabFolder, SWT.NONE);
		tbtmServerConfiguration.setText("Server Configuration");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmServerConfiguration.setControl(composite_1);
		
		Label lblServerPort = new Label(composite_1, SWT.NONE);
		lblServerPort.setBounds(114, 17, 66, 14);
		lblServerPort.setText("Server Port:");
		
		textfieldPort = new Text(composite_1, SWT.BORDER);
		textfieldPort.setText("1337");
		textfieldPort.setBounds(186, 14, 64, 19);
		
		Button btnStartServer = new Button(composite_1, SWT.NONE);
		btnStartServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				
				// Start the server class
				RoboticArmServer server = new RoboticArmServer(Integer.parseInt(textfieldPort.getText()));
				if (server.start())
					lblServerStatus.setText("Server started");
				else
					lblServerStatus.setText("Unable to start");
				
			}
		});
		btnStartServer.setBounds(256, 10, 94, 28);
		btnStartServer.setText("Start Server");
		
		Label label_6 = new Label(composite_1, SWT.HORIZONTAL);
		label_6.setImage(SWTResourceManager.getImage("res/diagram.png"));
		label_6.setBounds(10, 248, 450, 206);
		
		lblServerStatus = new Label(composite_1, SWT.NONE);
		lblServerStatus.setAlignment(SWT.CENTER);
		lblServerStatus.setFont(SWTResourceManager.getFont("Lucida Grande", 18, SWT.NORMAL));
		lblServerStatus.setBounds(147, 46, 172, 49);
		lblServerStatus.setText("Server Stopped");

	}
}