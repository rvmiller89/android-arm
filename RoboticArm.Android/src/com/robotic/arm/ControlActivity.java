package com.robotic.arm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class ControlActivity extends Activity {
	
	private static String server;
	private static int port;
	private Handler connectionHandler;
	private boolean isConnected;
	private Button button1Up, button1Down, button2Up, button2Down, button3Up, button3Down, button4Up, button4Down;
	private static final int MOTOR_1_UP = 0;
	private static final int MOTOR_1_DOWN = 1;
	private static final int MOTOR_2_UP = 2;
	private static final int MOTOR_2_DOWN = 3;
	private static final int MOTOR_3_UP = 4;
	private static final int MOTOR_3_DOWN = 5;
	private static final int MOTOR_4_UP = 6;
	private static final int MOTOR_4_DOWN = 7;
	private static final int DISCONNECT = 8;
	private static final String COMMAND = "command";
	
	private Message msg;
	private Bundle cmdBundle;
	private Command cmd;
	
	private Context ctx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        
        ctx = this;
        
        isConnected = false;
        
        Bundle receiveBundle = this.getIntent().getExtras();
        server = receiveBundle.getString(this.getString(R.string.server_value));
        port = receiveBundle.getInt(this.getString(R.string.port_value));
        
        /*
         * Start the child thread.
         */
        try {
			new Connection().start();
		} catch (Exception e) {
			e.printStackTrace();
			//Toast.makeText(ctx, "Unable to start connection", Toast.LENGTH_LONG).show();
			//this.finish();
		}
        
        button1Up = (Button) this.findViewById(R.id.button1Up);
        button1Up.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				msg = new Message();
				cmdBundle = new Bundle();
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					cmd = new Command(Command.Type.MOTOR_START, new Command.Motor(1, Command.Motor.FORWARD));
				else if (event.getAction() == MotionEvent.ACTION_UP)
					cmd = new Command(Command.Type.MOTOR_STOP, new Command.Motor(1, Command.Motor.FORWARD));
				else
					return false;
				cmdBundle.putSerializable(COMMAND, cmd);
				msg.setData(cmdBundle);
				connectionHandler.sendMessage(msg);
				return false;
			}
        });
        button1Down = (Button) this.findViewById(R.id.button1Down);
        button1Down.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				msg = new Message();
				cmdBundle = new Bundle();
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					cmd = new Command(Command.Type.MOTOR_START, new Command.Motor(1, Command.Motor.BACKWARD));
				else if (event.getAction() == MotionEvent.ACTION_UP)
					cmd = new Command(Command.Type.MOTOR_STOP, new Command.Motor(1, Command.Motor.BACKWARD));
				else
					return false;
				cmdBundle.putSerializable(COMMAND, cmd);
				msg.setData(cmdBundle);
				connectionHandler.sendMessage(msg);
				return false;
			}
        });
        button2Up = (Button) this.findViewById(R.id.button2Up);
        button2Up.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				msg = new Message();
				cmdBundle = new Bundle();
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					cmd = new Command(Command.Type.MOTOR_START, new Command.Motor(2, Command.Motor.FORWARD));
				else if (event.getAction() == MotionEvent.ACTION_UP)
					cmd = new Command(Command.Type.MOTOR_STOP, new Command.Motor(2, Command.Motor.FORWARD));
				else
					return false;
				cmdBundle.putSerializable(COMMAND, cmd);
				msg.setData(cmdBundle);
				connectionHandler.sendMessage(msg);
				return false;
			}
        });
        button2Down = (Button) this.findViewById(R.id.button2Down);
        button2Down.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				msg = new Message();
				cmdBundle = new Bundle();
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					cmd = new Command(Command.Type.MOTOR_START, new Command.Motor(2, Command.Motor.BACKWARD));
				else if (event.getAction() == MotionEvent.ACTION_UP)
					cmd = new Command(Command.Type.MOTOR_STOP, new Command.Motor(2, Command.Motor.BACKWARD));
				else
					return false;
				cmdBundle.putSerializable(COMMAND, cmd);
				msg.setData(cmdBundle);
				connectionHandler.sendMessage(msg);
				return false;
			}
        });
        button3Up = (Button) this.findViewById(R.id.button3Up);
        button3Up.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				msg = new Message();
				cmdBundle = new Bundle();
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					cmd = new Command(Command.Type.MOTOR_START, new Command.Motor(3, Command.Motor.FORWARD));
				else if (event.getAction() == MotionEvent.ACTION_UP)
					cmd = new Command(Command.Type.MOTOR_STOP, new Command.Motor(3, Command.Motor.FORWARD));
				else
					return false;
				cmdBundle.putSerializable(COMMAND, cmd);
				msg.setData(cmdBundle);
				connectionHandler.sendMessage(msg);
				return false;
			}
        });
        button3Down = (Button) this.findViewById(R.id.button3Down);
        button3Down.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				msg = new Message();
				cmdBundle = new Bundle();
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					cmd = new Command(Command.Type.MOTOR_START, new Command.Motor(3, Command.Motor.BACKWARD));
				else if (event.getAction() == MotionEvent.ACTION_UP)
					cmd = new Command(Command.Type.MOTOR_STOP, new Command.Motor(3, Command.Motor.BACKWARD));
				else
					return false;
				cmdBundle.putSerializable(COMMAND, cmd);
				msg.setData(cmdBundle);
				connectionHandler.sendMessage(msg);
				return false;
			}
        });
        button4Up = (Button) this.findViewById(R.id.button4Up);
        button4Up.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				msg = new Message();
				cmdBundle = new Bundle();
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					cmd = new Command(Command.Type.MOTOR_START, new Command.Motor(4, Command.Motor.FORWARD));
				else if (event.getAction() == MotionEvent.ACTION_UP)
					cmd = new Command(Command.Type.MOTOR_STOP, new Command.Motor(4, Command.Motor.FORWARD));
				else
					return false;
				cmdBundle.putSerializable(COMMAND, cmd);
				msg.setData(cmdBundle);
				connectionHandler.sendMessage(msg);
				return false;
			}
        });
        button4Down = (Button) this.findViewById(R.id.button4Down);
        button4Down.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				msg = new Message();
				cmdBundle = new Bundle();
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					cmd = new Command(Command.Type.MOTOR_START, new Command.Motor(4, Command.Motor.BACKWARD));
				else if (event.getAction() == MotionEvent.ACTION_UP)
					cmd = new Command(Command.Type.MOTOR_STOP, new Command.Motor(4, Command.Motor.BACKWARD));
				else
					return false;
				cmdBundle.putSerializable(COMMAND, cmd);
				msg.setData(cmdBundle);
				connectionHandler.sendMessage(msg);
				return false;
			}
        });
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_control, menu);
        return true;
    }
    
    public void onPause()	{
    	super.onPause();
    	
    	// TODO Close the connection
    	
    	this.finish();
    }
    
	public class Connection extends Thread {
		private Socket socket = null;
		private ObjectOutputStream output = null;
		
		public Connection() throws Exception {
			socket = new Socket(server, port);
			output = new ObjectOutputStream(socket.getOutputStream());
			
			isConnected = true;

			this.start();
		}
		
		public void disconnect()	{
			try	{
				output.close();
				socket.close();
			}
			catch (Exception e) {}
		}
		
		public void run()	{
			Looper.prepare();
			connectionHandler = new Handler() {
				
                public void handleMessage(Message msg) {
                	if (isConnected)	{
	                	Bundle bundle = msg.getData();
	                	Command cmd = (Command) bundle.getSerializable(COMMAND);
	                	try	{
	                		Log.d("Robotic Arm Control", "Sending command: " + cmd.motor.id);
	                		output.writeObject(cmd);
	                		output.flush();
	                	}
	                	catch (Exception e)	{
	                		Log.e("Robot Arm Controller", e.toString());
	                		Toast.makeText(ctx, "Could not send command", Toast.LENGTH_LONG).show();
	                	}
	                	
                	}
                	else	{
                		Toast.makeText(ctx, "Not connected to server", Toast.LENGTH_LONG).show();
                	}
                }
            };
			
			Looper.loop();
		}
	}
    
}
