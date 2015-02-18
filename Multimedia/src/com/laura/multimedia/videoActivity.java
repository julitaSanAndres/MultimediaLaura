package com.laura.multimedia;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class videoActivity extends ActionBarActivity {
	private VideoView video;
	private Button bVolver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);

		video = (VideoView) findViewById(R.id.videoView1);
		Uri path = Uri
				.parse("android.resource://com.laura.video/" + R.raw.chip);

		// AMPLIACIÓN para que salgan los controles de reproduccion

		MediaController mc = new MediaController(this);
		video.setMediaController(mc);

		//para que se inicie
		video.setVideoURI(path);
		video.start();
		
		bVolver = (Button)findViewById(R.id.buttonVolver);
		bVolver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// enviar a la actividad = videoActivity
				Intent i = new Intent(getApplication(), MainActivity.class);
		        startActivity(i);
			}
		});

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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
