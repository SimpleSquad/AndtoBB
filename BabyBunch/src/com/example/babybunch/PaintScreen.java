package com.example.babybunch;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

 

import android.os.Bundle; 
import android.os.Environment;
 
import android.app.Activity;
import android.app.AlertDialog; 
import android.content.DialogInterface; 
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
 

public class PaintScreen extends Activity implements OnClickListener,TextToSpeech.OnInitListener  {
	//custom drawing view
	private DrawingView drawView;
	//buttons
	private ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn;
	private TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_paint_screen);	
		
		tts =new TextToSpeech(this,this);
		
		drawView = (DrawingView)findViewById(R.id.drawing);
		String strg  = getIntent().getExtras().getString("value");
		
		if (strg.equals("1")) {
			drawView.setBackgroundColor(Color.parseColor("#ffffff"));
		} else if(strg.equals("2")) {
			drawView.setBackground(getResources().getDrawable(R.drawable.page1));
		}else if(strg.equals("3")) {
			drawView.setBackground(getResources().getDrawable(R.drawable.page2));
		}else if(strg.equals("4")) {
			drawView.setBackground(getResources().getDrawable(R.drawable.page3));
		}else if(strg.equals("5") ){
			drawView.setBackground(getResources().getDrawable(R.drawable.page4));
		}else if(strg.equals("6")) {
			drawView.setBackground(getResources().getDrawable(R.drawable.page5));
		}else if(strg.equals("7")) {
			drawView.setBackground(getResources().getDrawable(R.drawable.page6));
		}else if(strg.equals("8")) {
			drawView.setBackground(getResources().getDrawable(R.drawable.page7));
		}else if(strg.equals("9")) {
			drawView.setBackground(getResources().getDrawable(R.drawable.page8));
		}else if(strg.equals("10")) {
			drawView.setBackground(getResources().getDrawable(R.drawable.page9));
		}
		
		
		LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
		currPaint = (ImageButton)paintLayout.getChildAt(0);
		
		drawBtn = (ImageButton)findViewById(R.id.draw_btn);
		drawBtn.setOnClickListener(this);
		
		eraseBtn = (ImageButton)findViewById(R.id.erase_btn);
		eraseBtn.setOnClickListener(this);
		
		newBtn = (ImageButton)findViewById(R.id.new_btn);
		newBtn.setOnClickListener(this);
		
		saveBtn = (ImageButton)findViewById(R.id.save_btn);
		saveBtn.setOnClickListener(this);      
 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.paint_screen, menu);
		return true;
	}

	//user clicked paint
	public void paintClicked(View view){
		String color = view.getTag().toString();    
		speakOut(color);
			drawView.setErase(false);			
			drawView.setColor(color); 
			
			}

	@Override
	public void onClick(View view){

		if(view.getId()==R.id.draw_btn){
			drawView.setErase(false);
		}
		else if(view.getId()==R.id.erase_btn){
			drawView.setErase(true);	 
		}else if(view.getId()==R.id.save_btn){
            //save drawing
			AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
			saveDialog.setTitle("Save drawing");
			saveDialog.setMessage("Do you want to save This?");
			saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
			    public void onClick(DialogInterface dialog, int which){ 
			    	drawView.setDrawingCacheEnabled(true);
			    	  Bitmap bitmap = drawView.getDrawingCache();
			    		SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
			    		String format = s.format(new Date());
			    	    File imagePath = new File(Environment.getExternalStorageDirectory() + "/DCIM/100ANDRO/babybunch"+format+".JPEG");
			    	    FileOutputStream fos;
			    	    try {
			    	        fos = new FileOutputStream(imagePath);
			    	        bitmap.compress(CompressFormat.JPEG, 100, fos);
			    	        fos.flush();
			    	        fos.close();
			    	    } catch (FileNotFoundException e) {
			    	        Log.e("GREC", e.getMessage(), e);
			    	    } catch (IOException e) {
			    	        Log.e("GREC", e.getMessage(), e);
			    	    }
			    }
			});
			saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
			    public void onClick(DialogInterface dialog, int which){
			        dialog.cancel();
			    }
			});
			saveDialog.show();
        }
		else if(view.getId()==R.id.new_btn){
			//new button
			AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
			newDialog.setTitle("New drawing");
			newDialog.setMessage("Do you want to draw a new one ? this picture you draw will be gone then.");
			newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					drawView.startNew();
					dialog.dismiss();
				}
			});
			newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					dialog.cancel();
				}
			});
			newDialog.show();
		}
 
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub

		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);	

		} else {
			Log.e("TTS", "Initilization Failed");
		}
		
	}
	

	private void speakOut(String colour) {

		String word ;
		tts.setSpeechRate((float) 0.25);
		if(colour.equalsIgnoreCase("#FF660000")){
			word ="brown";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FFFF6600")) {
			word ="orange";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FFFF0000")) {
			word ="red";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FFFFCC00")) {
			word ="yellow";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FF009900")) {
			word ="green";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FF009999")) {
			word ="light blue";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FF0000FF")) {
			word ="blue";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FF990099")) {
			word ="purple";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FFFF6666")) {
			word ="pink";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FFFFFFFF")) {
			word ="white";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FF787878")) {
			word ="gray";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}else if (colour.equalsIgnoreCase("#FF000000")) {
			word ="black";
			tts.speak(word, TextToSpeech.QUEUE_FLUSH, null);
		}
		
		
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
	       if (keyCode == KeyEvent.KEYCODE_BACK ) {

				AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
				newDialog.setTitle("Exit");
				newDialog.setMessage("Do you want to Save before you leave ?");
				newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){	
						drawView.setDrawingCacheEnabled(true);
				    	  Bitmap bitmap = drawView.getDrawingCache();
				    		SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
				    		String format = s.format(new Date());
				    	    File imagePath = new File(Environment.getExternalStorageDirectory() + "/DCIM/100ANDRO/babybunch"+format+".JPEG");
				    	    FileOutputStream fos;
				    	    try {
				    	        fos = new FileOutputStream(imagePath);
				    	        bitmap.compress(CompressFormat.JPEG, 100, fos);
				    	        fos.flush();
				    	        fos.close();
				    	    } catch (FileNotFoundException e) {
				    	        Log.e("GREC", e.getMessage(), e);
				    	    } catch (IOException e) {
				    	        Log.e("GREC", e.getMessage(), e);
				    	    }
				    	    Intent intent = new Intent(PaintScreen.this, MainMenu.class);
				    	    dialog.dismiss();  
				    	    finishAffinity();
				    	    
				    	    startActivityForResult(intent, 0);
					    	    
					    	  			
					}
				});
				newDialog.setNegativeButton("No", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						 Intent intent = new Intent(PaintScreen.this, MainMenu.class);
						   dialog.dismiss();
						 finishAffinity();
				    	   startActivityForResult(intent, 0);
				    	    
				    	
				     
						
					}
				});
				newDialog.setNeutralButton("Stay", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						dialog.cancel();
					}
				});
				newDialog.show();

	       }
	       return super.onKeyDown(keyCode, event);
	   }
	
	
}
