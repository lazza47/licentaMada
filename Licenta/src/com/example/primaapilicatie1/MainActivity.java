package com.example.primaapilicatie1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addMese();
		// cod android.info64
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.bell);
		Button click = (Button) this.findViewById(R.id.button1);

		click.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.start();
				Intent intent = new Intent(v.getContext(), LogInActivity.class);
				startActivityForResult(intent, 0);
			}
		});

	}

	public void addMese() {
		Restaurant.addMasa("masa1", "abcd1x");
		Restaurant.addMasa("masa2", "abcd2x");
		Restaurant.addMasa("masa3", "abcd3x");
		Restaurant.addMasa("masa4", "abcd4x");
		Restaurant.addMasa("masa5", "abcd5x");
		Restaurant.addMasa("masa6", "abcd6x");
		Restaurant.addMasa("masa7", "abcd7x");
		Restaurant.addMasa("masa8", "abcd8x");
		Restaurant.addMasa("masa9", "abcd9x");
		Restaurant.addMasa("masa10", "abcd0x");

	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

	/** Called when the user clicks the Enter button */
	// public void enterApp(View view) {
	// Intent intent = new Intent(this, LogInActivity.class);
	// startActivity(intent);
	// }

}
