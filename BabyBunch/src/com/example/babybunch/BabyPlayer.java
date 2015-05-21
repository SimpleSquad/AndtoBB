package com.example.babybunch;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
//import android.graphics.LightingColorFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
//import android.widget.RadioGroup;

public class BabyPlayer extends ActionBarActivity {


	 String radioflag ="r1",playerflag = "start",nowPlay="r1" ; 
	 
	   Button stop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baby_player);
		///////////////////////////////////////////////////
	//	final MediaPlayer song;
		final Button play = (Button)findViewById(R.id.button1);
		final Button pause = (Button)findViewById(R.id.button2);
		 stop = (Button)findViewById(R.id.button3);
	//	final RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroup);
		final RadioButton r1 = (RadioButton)findViewById(R.id.radioButton1);
		final RadioButton r2 = (RadioButton)findViewById(R.id.radioButton2);
		final RadioButton r3 = (RadioButton)findViewById(R.id.radioButton3);
		final RadioButton r4 = (RadioButton)findViewById(R.id.radioButton4);
		final RadioButton r5 = (RadioButton)findViewById(R.id.radioButton5);
		final RadioButton r6 = (RadioButton)findViewById(R.id.radioButton6);
		final RadioButton r7 = (RadioButton)findViewById(R.id.radioButton7);
		final RadioButton r8 = (RadioButton)findViewById(R.id.radioButton8);
		final RadioButton r9 = (RadioButton)findViewById(R.id.radioButton9);
		final RadioButton r10 = (RadioButton)findViewById(R.id.radioButton10);
		final RadioButton r11 = (RadioButton)findViewById(R.id.radioButton11);
		final RadioButton r12 = (RadioButton)findViewById(R.id.radioButton12);
		/////////////////////////////////////////////////////////////////////
		final	MediaPlayer u1 = MediaPlayer.create(BabyPlayer.this,R.raw.abc);
		final	MediaPlayer u2 = MediaPlayer.create(BabyPlayer.this,R.raw.hakunamatata);
		final	MediaPlayer u3 = MediaPlayer.create(BabyPlayer.this,R.raw.ifyouarehappy);
		final	MediaPlayer u4 = MediaPlayer.create(BabyPlayer.this,R.raw.imalittleteapot);
		final	MediaPlayer u5 = MediaPlayer.create(BabyPlayer.this,R.raw.itsybitsyspider);
		final	MediaPlayer u6 = MediaPlayer.create(BabyPlayer.this,R.raw.londonbridge);
		final	MediaPlayer u7 = MediaPlayer.create(BabyPlayer.this,R.raw.maryhadalittlelamb);
		final	MediaPlayer u8 = MediaPlayer.create(BabyPlayer.this,R.raw.onetwobucklemyshoe);
		final	MediaPlayer u9 = MediaPlayer.create(BabyPlayer.this,R.raw.takemeouttothe);
		final	MediaPlayer u10 = MediaPlayer.create(BabyPlayer.this,R.raw.thisoldman);
		final	MediaPlayer u11 = MediaPlayer.create(BabyPlayer.this,R.raw.twinkletwinkle);
		final	MediaPlayer u12 = MediaPlayer.create(BabyPlayer.this,R.raw.youaremysunshine);
		   
	
		
            // button shack start
              play.setOnClickListener(new OnClickListener() {
			
		         	public void onClick(View v) {
		         		
		         		if (playerflag =="ok" ||playerflag == "start") {
							nowPlay = radioflag;							
							if (nowPlay =="r1") {
								u1.start();
							} else if(nowPlay =="r2") {
								u2.start();
							}else if(nowPlay =="r3") {
								u3.start();
							}else if(nowPlay =="r4") {
								u4.start();
							}else if(nowPlay =="r5") {
								u5.start();
							}else if(nowPlay =="r6") {
								u6.start();
							}else if(nowPlay =="r7") {
								u7.start();
							}else if(nowPlay =="r8") {
								u8.start();
							}else if(nowPlay =="r9") {
								u9.start();
							}else if(nowPlay =="r10") {
								u10.start();
							}else if(nowPlay =="r11") {
								u11.start();
							}else if(nowPlay =="r12") {
								u12.start();
							}							
			 			}else if (playerflag =="pause") {
			 				if (nowPlay =="r1") {
								u1.start();
							} else if(nowPlay =="r2") {
								u2.start();
							}else if(nowPlay =="r3") {
								u3.start();
							}else if(nowPlay =="r4") {
								u4.start();
							}else if(nowPlay =="r5") {
								u5.start();
							}else if(nowPlay =="r6") {
								u6.start();
							}else if(nowPlay =="r7") {
								u7.start();
							}else if(nowPlay =="r8") {
								u8.start();
							}else if(nowPlay =="r9") {
								u9.start();
							}else if(nowPlay =="r10") {
								u10.start();
							}else if(nowPlay =="r11") {
								u11.start();
							}else if(nowPlay =="r12") {
								u12.start();
							}					
						} 
		         		playerflag = "stop";
				
			    }
		          });
             pause.setOnClickListener(new OnClickListener() {
 	
            	public void onClick(View v) {
		 
            		playerflag ="pause";
            		if (nowPlay =="r1") {
						u1.pause();
					} else if(nowPlay =="r2") {
						u2.pause();
					}else if(nowPlay =="r3") {
						u3.pause();
					}else if(nowPlay =="r4") {
						u4.pause();
					}else if(nowPlay =="r5") {
						u5.pause();
					}else if(nowPlay =="r6") {
						u6.pause();
					}else if(nowPlay =="r7") {
						u7.pause();
					}else if(nowPlay =="r8") {
						u8.pause();
					}else if(nowPlay =="r9") {
						u9.pause();
					}else if(nowPlay =="r10") {
						u10.pause();
					}else if(nowPlay =="r11") {
						u11.pause();
					}else if(nowPlay =="r12") {
						u12.pause();
					}				
		
	           } 
                 });
             stop.setOnClickListener(new OnClickListener() {
	
	           public void onClick(View v) {
	        	   
	        	   
	        	   playerflag ="ok";
	        	   if (nowPlay =="r1") {
	        		   u1.seekTo(0);
						u1.stop();
						try {
							u1.prepare();
						} catch (Exception e) {
							 
						}
						
						
					} else if(nowPlay =="r2") {
						 u2.seekTo(0);
							u2.stop();
							try {
								u2.prepare();
							} catch (Exception e) {
								 
							}
					}else if(nowPlay =="r3") {
						 u3.seekTo(0);
							u3.stop();
							try {
								u3.prepare();
							} catch (Exception e) {
								 
							}
					}else if(nowPlay =="r4") {
						 u4.seekTo(0);
							u4.stop();
							try {
								u4.prepare();
							} catch (Exception e) {
							 
							}
					}else if(nowPlay =="r5") {
						 u5.seekTo(0);
							u5.stop();
							try {
								u5.prepare();
							} catch (Exception e) {
								 
							}
					}else if(nowPlay =="r6") {
						 u6.seekTo(0);
							u6.stop();
							try {
								u6.prepare();
							} catch (Exception e) {
								 
							}
					}else if(nowPlay =="r7") {
						 u7.seekTo(0);
							u7.stop();
							try {
								u7.prepare();
							} catch (Exception e) {
							 
							}
					}else if(nowPlay =="r8") {
						u8.seekTo(0);
						u8.stop();
						try {
							u8.prepare();
						} catch (Exception e) {
							 
						}
					}else if(nowPlay =="r9") {
						u9.seekTo(0);
						u9.stop();
						try {
							u9.prepare();
						} catch (Exception e) {
							 
						}
					}else if(nowPlay =="r10") {
						u10.seekTo(0);
						u10.stop();
						try {
							u10.prepare();
						} catch (Exception e) {
							 
						}
					}else if(nowPlay =="r11") {
						u11.seekTo(0);
						u11.stop();
						try {
							u11.prepare();
						} catch (Exception e) {
							 
						}
					}else if(nowPlay =="r12") {
						u12.seekTo(0);
						u12.stop();
						try {
							u12.prepare();
						} catch (Exception e) {
							 
						}
					}
		
            	}
                 });
             // button shack end
		
            
             
		// radio shack start
          r1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 
				radioflag = "r1";
				
			}
		});
          
          r2.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r2";
  			}
  		});
          
          r3.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r3";
  			}
  		});
          
          r4.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r4";
  			}
  		});
          
          r5.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r5";
  			}
  		});
          
          r6.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r6";
  			}
  		});
          
          r7.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r7";
  			}
  		});
          
          r8.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r8";
  			}
  		});
          
          r9.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r9";
  			}
  		});
          
          r10.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r10";
  			}
  		});
          
          r11.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r11";
  			}
  		});
          
          r12.setOnClickListener(new OnClickListener() {
  			
  			public void onClick(View v) {
  				 
  				radioflag = "r12";
  			}
  		});
        // radio shack end  
        
		//////////////////////////////////////////////////
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.baby_player, menu);
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
	           stop.performClick();
	    	   Intent intent = new Intent(BabyPlayer.this, MainMenu.class);
	    	   finishAffinity();
	    	   startActivityForResult(intent, 0);
	    	   
	       }
	       return super.onKeyDown(keyCode, event);
	   }
	
	
	
}
