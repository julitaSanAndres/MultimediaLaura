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
import android.widget.TextView;

public class Fragment_imagenes extends Fragment {
	
	View rootView;
	private Button b_camara, b_galeria;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.imagenes_galeria_camara, container, false);
		
		
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		b_camara = (Button)getActivity().findViewById(R.id.buttonCamara);
		b_galeria = (Button)getActivity().findViewById(R.id.buttonGaleria);
		
		b_camara.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent camaraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivity(camaraIntent);
			}
		});
		b_galeria.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intenGaleria = new Intent(Intent.ACTION_VIEW, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivity(intenGaleria);
			}
		});
		
	}
}
