package com.example.bdac;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;


public class SplashAnimation extends Activity {

	private static String TAG = SplashAnimation.class.getName();
	private static long SLEEP_TIME = 5;
	
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       
        
        setContentView(R.layout.activity_splash);
        
        
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
    }
    
    private class IntentLauncher extends Thread{
    	
    	@Override
    	public void run() {
    		try{
    			Thread.sleep(SLEEP_TIME*1000);
    		} catch (Exception e){
    			Log.e(TAG, e.getMessage());
    		}
    		
    		Intent intent = new Intent(SplashAnimation.this, MainActivity.class);
    		SplashAnimation.this.startActivity(intent);
    		SplashAnimation.this.finish();
    	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
       
        return super.onOptionsItemSelected(item);
    }
}
