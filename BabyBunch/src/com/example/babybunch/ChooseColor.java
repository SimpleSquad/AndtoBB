package com.example.babybunch;

import java.util.Locale;
import java.util.Random;

 

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
 

public class ChooseColor extends  Activity implements
TextToSpeech.OnInitListener{
    
	String colour;
	int col=78;
	int rand;
	private TextToSpeech tts;
	private Button btnSpeak;
	private Button btnRepeat;
	private Button blue;
	private Button green;
	private Button pink;
	private Button red;
	private Button yellow;
	private Button purple;
	private Button black;
	private Button brown;
	private Button white;
 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_color);

		tts = new TextToSpeech(this, this);
		
		btnSpeak = (Button) findViewById(R.id.btnSpeak);
		btnRepeat = (Button)findViewById(R.id.button10);
		    blue = (Button) findViewById(R.id.button1);
		    green= (Button) findViewById(R.id.button2);
		    pink= (Button) findViewById(R.id.button3);
		    red= (Button) findViewById(R.id.button5);
		    yellow= (Button) findViewById(R.id.button6);
		    purple= (Button) findViewById(R.id.button4);
		    black= (Button) findViewById(R.id.button7);
		    brown= (Button) findViewById(R.id.button8);
		    white= (Button) findViewById(R.id.button9);
		   final  MediaPlayer loss = MediaPlayer.create(ChooseColor.this,R.raw.tryagn);
		   final  MediaPlayer win = MediaPlayer.create(ChooseColor.this,R.raw.yaay);
		    
		    white.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="White") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		   
		    brown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="Brown") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		   
		    black.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="Black") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		   purple.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="Purple") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		    yellow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="Yellow") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		    red.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="Red") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		   
		    pink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="Pink") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		   
		    green.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="Green") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		   
		   
		    blue.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (colour =="Blue") {
					win.start();
				}else
				{
					loss.start();
				}
			}

		});
		
		btnSpeak.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				speakOut();
			}

		});
		
		btnRepeat.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Repeatout();
			}

		});
	}

	@Override
	public void onDestroy() {
 
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}

	@Override
	public void onInit(int status) {
 		// TODO Auto-generated method stub

		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "Language is not supported");
			} else {
				btnSpeak.setEnabled(true);
			//	speakOut();
			}

		} else {
			Log.e("TTS", "Initilization Failed");
		}

	}

	private void speakOut() {
		tts.setSpeechRate((float) 0.25);
		Random a = new Random();
		 rand = a.nextInt(9);
		
		if(col==78){colour ="Blue";col=0;}
		else{
		if(rand == col ){speakOut();}
		else{
		if(rand==0){colour ="Blue";col =0;}
		else if(rand==1){colour ="Green";col =1;}
		else if(rand==2){colour ="Pink";col =2;}
		else if(rand==3){colour ="Red";col =3;}
		else if(rand==4){colour ="Yellow";col =4;}
		else if(rand==5){colour ="Purple";col =5;}
		else if(rand==6){colour ="Black";col =6;}
		else if(rand==7){colour ="Brown";col =7;}
		else {colour ="White";col =8;}
		}	 	 
		}
		tts.speak(colour, TextToSpeech.QUEUE_FLUSH, null);
	}
	
	private void Repeatout() {
		tts.speak(colour, TextToSpeech.QUEUE_FLUSH, null);
	}
	
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
	       if (keyCode == KeyEvent.KEYCODE_BACK ) {
	       //stop.performClick();
	    	   Intent intent = new Intent(ChooseColor.this, MainMenu.class);
	    	   finishAffinity();
	    	   startActivityForResult(intent, 0);
	    	    
	       }
	       return super.onKeyDown(keyCode, event);
	   }
	
	
}
