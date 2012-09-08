package com.robotic.arm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ControlActivity extends Activity {
	
	private static String server;
	private static int port;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        
        Bundle receiveBundle = this.getIntent().getExtras();
        server = receiveBundle.getString(this.getString(R.string.server_value));
        port = receiveBundle.getInt(this.getString(R.string.port_value));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_control, menu);
        return true;
    }
}
