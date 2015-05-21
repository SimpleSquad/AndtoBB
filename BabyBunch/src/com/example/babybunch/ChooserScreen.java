package com.example.babybunch;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ChooserScreen extends ActionBarActivity {

	private Button p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
	String a;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chooser_screen);
		
		p1 = (Button) findViewById(R.id.button1);
	    p2= (Button) findViewById(R.id.button2);
	    p3= (Button) findViewById(R.id.button3);
	    p4= (Button) findViewById(R.id.button4);
	    p5= (Button) findViewById(R.id.button5);
	    p6= (Button) findViewById(R.id.button6);
	    p7= (Button) findViewById(R.id.button7);
	    p8= (Button) findViewById(R.id.button8);
	    p9= (Button) findViewById(R.id.button9);
	    p10= (Button) findViewById(R.id.button10);
	    
	    p1.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			
			a="1";
			Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
			intent.putExtra("value", a);
			startActivity(intent);
			android.os.Process.killProcess(android.os.Process.myPid());
			
		}

	});
	    
	    p2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="2";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
				
			}

		});
	    
	    p3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="3";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
				
			}

		});
	    
	    p4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="4";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
			}

		});
	    
	    p5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="5";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
			}

		});
	    
	    p6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="6";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
			}

		});
	    
	    p7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="7";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
				
			}

		});
	    
	    p8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="8";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
				
			}

		});
	    
	    p9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="9";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
				
			}

		});
	    
	    p10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				a="10";
				Intent intent = new Intent(ChooserScreen.this, PaintScreen.class);
				intent.putExtra("value", a);
				startActivity(intent);
				android.os.Process.killProcess(android.os.Process.myPid());
				
			}

		});
	    
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chooser_screen, menu);
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
	    	   Intent intent = new Intent(ChooserScreen.this, MainMenu.class);
	    	   finishAffinity();
	    	   startActivityForResult(intent, 0);
	    	   
	       }
	       return super.onKeyDown(keyCode, event);
	   }
}
