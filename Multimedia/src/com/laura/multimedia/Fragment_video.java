package com.laura.multimedia;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;



public class Fragment_video extends Fragment {
	
	View rootView;
	
	private Button b_video;

	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.video_frag, container, false);
		
		
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		b_video = (Button) getActivity().findViewById(R.id.buttonVideo);
		
		b_video.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// enviar a la actividad = videoActivity
				Intent i = new Intent(getActivity(), videoActivity.class);
		        startActivity(i);
			}
		});
		
	}
	

	
}
