package com.example.bdac;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;

public class Events extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addListenerOnButton();
    }
	public void addListenerOnButton() {

		final ImageView image = (ImageView) findViewById(R.id.imageView1);

		Button button = (Button) findViewById(R.id.btnChangeImage);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				image.setImageResource(R.drawable.images);
			}

		});

	}
	
}
