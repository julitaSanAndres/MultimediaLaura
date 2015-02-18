package com.laura.audio;

import android.support.v7.app.ActionBarActivity;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends ActionBarActivity {
	private SoundManager snd; // definir la carga de los archivos de sonido y
								// sus propiedades de reproducción

	// guardan los id’s de cada uno de los archivos de audio que guardamos en el
	// directorio res > raw
	private int gato, grillos, muelle, risa, tambor, tormenta;
	private OnSeekBarChangeListener barChange; // controlarán los cambios hechos
												// a cada una de las SeekBar de
												// la app.
	private OnClickListener buttonClick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// crear la instancia en el objeto SoundManager
		snd = new SoundManager(getApplicationContext());
		// Para que el boton de mas y del menos del movil funcione para subir y
		// bajar el volumen cuando se este reproduciendo
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

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
		sb = (SeekBar) findViewById(R.id.SpeedBar);
		sb.setOnSeekBarChangeListener(barChange);

		sb = (SeekBar) findViewById(R.id.balBar);
		sb.setOnSeekBarChangeListener(barChange);

		sb = (SeekBar) findViewById(R.id.volBar1);
		sb.setOnSeekBarChangeListener(barChange);
	}
/**
 * controlar cada uno de los eventos de click hechos a cada uno de los seis botones de la interfaz.
 * @param v
 */
	public void clickHandler(View v) {
		int id = v.getId(); // Use the button id to determine which sample
							// should be played
		//hace la selección del botón presionado a través del ID de la vista que recibe como parámetro
		switch (id) {
		case R.id.b_gato:
			snd.play(gato);
			//esta la he definido para imprimir en la pestaña de Log de Eclipse qué botón se está presionando
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
