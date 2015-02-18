package com.laura.multimedia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Fragment_Audio_soundP extends Fragment {
	private Button b1, b2, b3, b4, b5, b6;
	View rootView;

	private SoundManager snd; // definir la carga de los archivos de sonido y
	// sus propiedades de reproducción

	// guardan los id’s de cada uno de los archivos de audio que guardamos en el
	// directorio res > raw
	private int gato, grillos, muelle, risa, tambor, tormenta;
	private OnSeekBarChangeListener barChange; // controlarán los cambios hechos
	// a cada una de las SeekBar de la app.
	private OnClickListener buttonClick;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater
				.inflate(R.layout.audio_sound_pool, container, false);

		return rootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		b1 = (Button) getActivity().findViewById(R.id.b_gato);
		b2 = (Button) getActivity().findViewById(R.id.b_grillos);
		b3 = (Button) getActivity().findViewById(R.id.b_muelle);
		b4 = (Button) getActivity().findViewById(R.id.b_risa);
		b5 = (Button) getActivity().findViewById(R.id.b_tambor);
		b6 = (Button) getActivity().findViewById(R.id.b_tormenta);

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clickHandler(v);
			}
		});
		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clickHandler(v);
			}
		});
		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clickHandler(v);
			}
		});
		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clickHandler(v);
			}
		});
		b5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clickHandler(v);
			}
		});
		b6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clickHandler(v);
			}
		});

		// crear la instancia en el objeto SoundManager
		snd = new SoundManager(getActivity());

		// inicializamos todas las variables int con los id’s de los archivos de
		// audio de nuestro proyecto
		gato = snd.load(R.raw.gato);
		grillos = snd.load(R.raw.grillos);
		muelle = snd.load(R.raw.muelle);
		risa = snd.load(R.raw.risa);
		tambor = snd.load(R.raw.tambor);
		tormenta = snd.load(R.raw.tormenta);

		// creación del manejador de eventos de las SeekBar en el que
		// recuperamos
		// las referencias de los widgets SeekBar del archivo main.xml,

		barChange = new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				switch (seekBar.getId()) {
				case R.id.volBar1:
					snd.setVolume((float) progress / 100.0f);
					break;

				case R.id.balBar:
					snd.setBalance((float) progress / 100.0f);
					break;

				case R.id.SpeedBar:
					snd.setSpeed((float) progress / 100.0f);
					break;
				}
			}
		};
		// le asignamos este listener a cada SeekBar para que podamos
		// trabajar con las variaciones que el usuario haga en la aplicación.
		SeekBar sb;
		sb = (SeekBar) getActivity().findViewById(R.id.SpeedBar);
		sb.setOnSeekBarChangeListener(barChange);

		sb = (SeekBar) getActivity().findViewById(R.id.balBar);
		sb.setOnSeekBarChangeListener(barChange);

		sb = (SeekBar) getActivity().findViewById(R.id.volBar1);
		sb.setOnSeekBarChangeListener(barChange);

	}

	/**
	 * controlar cada uno de los eventos de click hechos a cada uno de los seis
	 * botones de la interfaz.
	 * 
	 * @param v
	 */
	public void clickHandler(View v) {
		int id = v.getId(); // Use the button id to determine which sample
							// should be played
		// hace la selección del botón presionado a través del ID de la vista
		// que recibe como parámetro
		switch (id) {
		case R.id.b_gato:
			snd.play(gato);
			// esta la he definido para imprimir en la pestaña de Log de Eclipse
			// qué botón se está presionando
			Log.i("---", "Button gato");
			break;

		case R.id.b_grillos:
			snd.play(grillos);
			Log.i("---", "Button grillos");
			break;

		case R.id.b_muelle:
			snd.play(muelle);
			Log.i("---", "Button muelle");
			break;

		case R.id.b_risa:
			snd.play(risa);
			Log.i("---", "Button risa");
			break;

		case R.id.b_tambor:
			snd.play(tambor);
			Log.i("---", "Button tambor");
			break;

		case R.id.b_tormenta:
			snd.play(tormenta);
			Log.i("---", "Button tormenta");
			break;
		}
	}

}
