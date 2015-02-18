package com.laura.multimedia;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager {
	private Context pContext;
	private SoundPool sndPool;
	private float rate = 1.0f;
	private float masterVolume = 1.0f;
	private float leftVolume = 1.0f;
	private float rightVolume = 1.0f;
	private float balance = 0.5f;

	/**
	 * permitirá inicializar un objeto de tipo SoundPool que define el volumen
	 * de los sonidos al 100% y con la capacidad de poder controlar el audio de
	 * la pista.
	 * 
	 * @param appContext
	 */
	@SuppressWarnings("deprecation")
	public SoundManager(Context appContext) {
		sndPool = new SoundPool(16, AudioManager.STREAM_MUSIC, 100);
		pContext = appContext;
	}
/**
 * cargar archivos
 * @param sound_id   recibe el id de la pista para que la elija de los
 *  archivos alojados físicamente en el proyecto
 * @return
 */
	public int load(int sound_id) {
		return sndPool.load(pContext, sound_id, 1);
	}
/**
 * reproducir archivos
 * @param sound_id  una función que nos permita reproducir la pista pasando como parámetro
 *  el resto de los ajustes como sonido, balance y velocidad.
 */
	public void play(int sound_id) {
		sndPool.play(sound_id, leftVolume, rightVolume, 1, 0, rate);
	}
	
	/**
	 * para controlar el seekbar del volumen
	 * @param vol
	 */
	public void setVolume(float vol) {
		masterVolume = vol;
		if(balance < 1.0f){
			leftVolume = masterVolume;
			rightVolume = masterVolume * balance;
		}else{
			rightVolume = masterVolume;
			leftVolume = masterVolume * (2.0f - balance);
		}
		
	}
	
	/**
	 * para controlar el seekbar de la velocidad
	 * @param speed
	 */
	public void setSpeed(float speed) {
		rate = speed;
		//si la velocicad es 0 no vale
		if(rate < 0.01f){
			rate = 0.01f;
		}
		//la velocidad no puede ser mayor de 2
		if(rate > 2.0f){
			rate = 2.0f;
		}
	}
	
	/**
	 * para controlar el seekbar de balance
	 * @param balVal
	 */
	public void setBalance(float balVal) {
		balance = balVal;
		//recalcula el nivel del volumen
		setVolume(masterVolume);
		
	}
}
