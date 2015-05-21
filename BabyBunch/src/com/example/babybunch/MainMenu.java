package com.example.babybunch;

import com.example.babybunch.R.color; 
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
 
 
import android.graphics.LightingColorFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
 
import android.view.View;
import android.view.View.OnClickListener;
 
 
import android.widget.Button;

public class MainMenu extends ActionBarActivity {
	String trig="off";
	  MediaPlayer mu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		  trig="off";
		mu = MediaPlayer.create(MainMenu.this,R.raw.menumusica);
		final Button piano = (Button)findViewById(R.id.button1);
		final Button art = (Button)findViewById(R.id.button2);
		final Button pick = (Button)findViewById(R.id.button3);
		final Button player = (Button)findViewById(R.id.button4);
		final Button help = (Button)findViewById(R.id.button5);
		final Button musica = (Button)findViewById(R.id.musical);
		MediaPlayer c = MediaPlayer.create(MainMenu.this,R.raw.asx);
        c.start();
        mu.setLooping(true);
        mu.start();
        musica.setBackgroundResource(color.green);
    
       
        
        musica.setOnClickListener(new OnClickListener() {
			
     			public void onClick(View v) {
     				
     				if(trig.equalsIgnoreCase("off")){
     					mu.pause();
     					mu.seekTo(0);
     					trig ="on"; 
     					musica.setBackgroundResource(color.red);
     				}
     				else{
     					mu.setLooping(true);
     					  mu.start();
     					trig ="off";
     					musica.setBackgroundResource(color.green);
     				}
     				 
     			}
     		});
        
        player.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),BabyPlayer.class);
				 finishAffinity();
				startActivityForResult(intent, 0);
				mu.pause();
					mu.seekTo(0);
					 
				 
			}
		});
        
		piano.setOnClickListener(new OnClickListener() {
				
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),PianoScreen.class);
				 finishAffinity();
				startActivityForResult(intent, 0);
				mu.pause();
					mu.seekTo(0);
					 
				 
			}
		});
	     
		art.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),ChooserScreen.class);
				 finishAffinity();
				startActivityForResult(intent, 0);
				
				mu.pause();
					mu.seekTo(0);
					 
				 
			}
		});
	     
      
	     
		pick.setOnClickListener(new OnClickListener() {
				
			public void onClick(View v) {
				
				Intent intent = new Intent(v.getContext(),ChooseColor.class);
				 finishAffinity();
				startActivityForResult(intent, 0);
			
				mu.pause();
					mu.seekTo(0);
					 
				
			}
		});
	     

	     
		help.setOnClickListener(new OnClickListener() {
				
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),Helper.class);
				 finishAffinity();
				startActivityForResult(intent, 0);
				help.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
				
				mu.pause();
					mu.seekTo(0);
					 
			}
		});
		
		
 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
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

				AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
				newDialog.setTitle("Exit");
				newDialog.setMessage("Do you want to stop ?");
				newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){						
						
						dialog.dismiss();
						android.os.Process.killProcess(android.os.Process.myPid());
						
 //System.exit(0);
					}
				});
				newDialog.setNegativeButton("No", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						dialog.cancel();
					}
				});
				newDialog.show();

	       }
	       return super.onKeyDown(keyCode, event);
	   }
}
