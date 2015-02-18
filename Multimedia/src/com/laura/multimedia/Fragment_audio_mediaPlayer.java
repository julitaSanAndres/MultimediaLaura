package com.laura.multimedia;



import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Fragment_audio_mediaPlayer extends Fragment {
	private MediaPlayer mp;
	private Button bPlay, bStop, bPause, bReanudar;
	View rootView;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.audio_media_player, container, false);

		
		return rootView;
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		bPlay = (Button) getActivity().findViewById(R.id.buttonPlay);
		bPause = (Button) getActivity().findViewById(R.id.buttonPause);
		bStop = (Button) getActivity().findViewById(R.id.buttonStop);
		bReanudar = (Button) getActivity().findViewById(R.id.buttonReanudar);

		bReanudar.setEnabled(false);
		bPause.setEnabled(false);
		bStop.setEnabled(false);

		bPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.start();
				bPause.setEnabled(true);
				bStop.setEnabled(true);
				bPlay.setEnabled(false);
			}
		});
		bPause.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.pause();
				bPause.setEnabled(false);
				bStop.setEnabled(true);
				bPlay.setEnabled(true);
			}
		});
		bStop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.stop();
				bReanudar.setEnabled(true);
				bPause.setEnabled(false);
				bStop.setEnabled(false);
				bPlay.setEnabled(false);
			}
		});
		// para reanudar cuando se da al pause
		bReanudar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					if (mp.isPlaying() == true) {
						mp.prepare();
						mp.start();
					} else {
						mp.prepareAsync();
						mp.setOnPreparedListener(new OnPreparedListener() {

							@Override
							public void onPrepared(MediaPlayer mp) {
								// TODO Auto-generated method stub
								mp.start();
							}
						});
					}
					bPause.setEnabled(true);
					bStop.setEnabled(true);
					bReanudar.setEnabled(false);

				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
	}
	/**
	 * El fragment se ha adjuntado al Activity
	 */
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mp = MediaPlayer.create(activity.getApplication(), R.raw.fragel);
	}
	
}
