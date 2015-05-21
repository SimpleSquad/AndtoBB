package com.example.babybunch;

import android.support.v7.app.ActionBarActivity; 
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;

public class PianoScreen extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_piano_screen);
		
		MediaPlayer c = MediaPlayer.create(PianoScreen.this,R.raw.muss);
        c.start();
		
		//buttons
		final Button one = (Button)findViewById(R.id.button1);
		final Button two = (Button)findViewById(R.id.button2);
		final Button three = (Button)findViewById(R.id.button3);
		final Button four = (Button)findViewById(R.id.button4);
		final Button five = (Button)findViewById(R.id.button5);
		final Button d1 = (Button)findViewById(R.id.button6);
		final Button d2 = (Button)findViewById(R.id.button7);
		final Button d3 = (Button)findViewById(R.id.button8);
		final Button d4 = (Button)findViewById(R.id.button9);
		//
		
		//music
	final	MediaPlayer u1 = MediaPlayer.create(PianoScreen.this,R.raw.pianohit1);
	final	MediaPlayer u2 = MediaPlayer.create(PianoScreen.this,R.raw.pianohit2);
	final	MediaPlayer u3 = MediaPlayer.create(PianoScreen.this,R.raw.pianohit3);
	final	MediaPlayer u4 = MediaPlayer.create(PianoScreen.this,R.raw.pianonewhit1);
	final	MediaPlayer u5 = MediaPlayer.create(PianoScreen.this,R.raw.pianonewhit2);
	final	MediaPlayer d11 = MediaPlayer.create(PianoScreen.this,R.raw.karakara);
	final	MediaPlayer d12 = MediaPlayer.create(PianoScreen.this,R.raw.asx);
	final	MediaPlayer d13 = MediaPlayer.create(PianoScreen.this,R.raw.fl);
	final	MediaPlayer d14 = MediaPlayer.create(PianoScreen.this,R.raw.loroomk1);
		//
		
		one.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 
				u1.start();
				one.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
			}
		});

		two.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 
				u2.start();
			}
		});	
		three.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 
				u3.start();
			}
		});

		four.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 
				u4.start();
			}
		});	
		five.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 
				u5.start();
			}
		});

		d1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				d11.start();
			}
		});	
		d2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				d12.start();
			}
		});

		d3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				d13.start();
			}
		});	
		
		d4.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				d14.start();
			}
		});	
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.piano_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
	       if (keyCode == KeyEvent.KEYCODE_BACK ) {
	       //stop.performClick();
	    	   Intent intent = new Intent(PianoScreen.this, MainMenu.class);
	    	   startActivityForResult(intent, 0);
	    	   android.os.Process.killProcess(android.os.Process.myPid());
	       }
	       return super.onKeyDown(keyCode, event);
	   }
	
}
