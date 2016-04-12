package com.example.bdac;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.app.Activity;


public class LogActivity extends Activity {

	String username,password;
	SQLiteDatabase db;
	TableRow tableRow;
	TextView textView,textView1,textView2,textView3,textView4;
	
	private static final String TABLE_NAME = "Member";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        db=openOrCreateDatabase("Androidlog2",MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Member(username VARCHAR,password VARCHAR);");
    
    }
    
    public void dataadd(View v)
    {
    	EditText edittext1 =(EditText)findViewById(R.id.name);
    	EditText edittext2 =(EditText)findViewById(R.id.password);
    	username=edittext1.getText().toString();
    	password=edittext2.getText().toString();
    	db.execSQL("INSERT INTO Member VALUES('"+username+"','"+password+"');");
    }
    public void showdata(View v)
    {
    	Cursor c=db.rawQuery("SELECT * from Member", null);
    	int count = c.getCount();
    	c.moveToFirst();
    	TableLayout tableLayout = new TableLayout(getApplicationContext());
    	tableLayout.setVerticalScrollBarEnabled(true);
    	TableRow tableRow;
    	TextView textView, textView1, textView2, textView4;
    	tableRow = new TableRow(getApplicationContext());
    	textView = new TextView(getApplicationContext());
    	textView.setText("Username");
    	textView.setTextColor(Color.RED);
    	textView.setTypeface(null, Typeface.BOLD);
    	textView.setPadding(20, 20, 20, 20);
    	tableRow.addView(textView);
    	textView4 = new TextView(getApplicationContext());
    	textView4.setText("Phone No");
    	textView4.setTextColor(Color.RED);
    	textView4.setTypeface(null, Typeface.BOLD);
    	textView4.setPadding(20, 20, 20, 20);
    	tableRow.addView(textView4);
    	
    	tableLayout.addView(tableRow);
    	
    	for (Integer j = 0; j < count; j++)
    	{
    		tableRow = new TableRow(getApplicationContext());
    		textView1 = new TextView(getApplicationContext());
    		textView1.setText(c.getString(c.getColumnIndex("username")));
    		textView2 = new TextView(getApplicationContext());
    		textView2.setText(c.getString(c.getColumnIndex("password")));
    		
    		textView1.setPadding(20, 20, 20, 20);
    		textView2.setPadding(20, 20, 20, 20);
    		
    		tableRow.addView(textView1);
    		tableRow.addView(textView2);
    		tableLayout.addView(tableRow);
    		c.moveToNext();
    	}
    	setContentView(tableLayout);
    	db.close();
    }
 
    
    public void login(View v)
    {
    	
    	
    	if(v.getId() == R.id.loginbtn)
    	{
    		EditText edittext1 =(EditText)findViewById(R.id.name);
        	EditText edittext2 =(EditText)findViewById(R.id.password);
        	username=edittext1.getText().toString();
        	password=edittext2.getText().toString();
        	
        	String query = "select username, password from member";
            Cursor cursor = db.rawQuery(query , null);
            if(cursor.moveToFirst()){
            String a, b;
            
                do{
                    a = cursor.getString(0);
                    b = cursor.getString(1);

                    if(a.equals(username))
                    {
                    	Intent intent = new Intent(LogActivity.this, LogActivity.class);
                		LogActivity.this.startActivity(intent);;
                        break;
                    }
                    
                }
               
            while(cursor.moveToNext());
        	if( b.equals(password))
            {
        		
        		Intent intent = new Intent(LogActivity.this, SplashAnimation.class);
        		LogActivity.this.startActivity(intent);;
            }
            else
            {
                Toast temp = Toast.makeText(LogActivity.this , "Username and password don't match!" , Toast.LENGTH_SHORT);
                temp.show();
            }
           }
          }
    	}
   
   
    
    public void closetheapp(View v)
    {
    	System.exit(0); 
    }
}
