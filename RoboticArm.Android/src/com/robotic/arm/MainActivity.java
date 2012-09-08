package com.robotic.arm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText serverText, portText;
	private Button connectButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        serverText = (EditText) this.findViewById(R.id.editTextServer);
        portText = (EditText) this.findViewById(R.id.editTextPort);
        connectButton = (Button) this.findViewById(R.id.buttonConnect);
        connectButton.setOnClickListener( new OnClickListener()	{
			@Override
			public void onClick(View arg0) {
				openControl();
			}
        });
    }
	
	public void openControl()	{
		Bundle sendBundle = new Bundle();
        sendBundle.putString(this.getString(R.string.server_value), serverText.getText().toString());
        int port;
        try	{
        	port = Integer.parseInt(portText.getText().toString());
        	sendBundle.putInt(this.getString(R.string.port_value), port);
        }
        catch (Exception e)	{
        	Toast.makeText(this, "Unable to parse port number", Toast.LENGTH_LONG).show();
        	return;
        }

        Intent i = new Intent(MainActivity.this, ControlActivity.class);
        i.putExtras(sendBundle);
        startActivity(i);

        finish();	// Go ahead and close the server info
	
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
