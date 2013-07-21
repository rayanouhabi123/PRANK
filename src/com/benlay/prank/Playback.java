package com.benlay.prank;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Toast;

public class Playback extends Activity {
Context ct;
	
     static MediaPlayer mediaPlayer;
   AudioManager audio;
 /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        audio =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
    }*/
    static void start(Context ctx){
    	mediaPlayer = MediaPlayer.create(ctx, R.raw.winter_dawn);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    mediaPlayer.setLooping(true);
    mediaPlayer.seekTo(0);
    mediaPlayer.start();
    }
    static void stop(Context ctx){
    mediaPlayer.stop();
    }
     void setVolMax(Context ctx){
    	 Toast.makeText(ctx, "here", Toast.LENGTH_LONG).show();
    	 audio =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
    	
    	while( (audio.getStreamVolume (AudioManager.STREAM_MUSIC))!=( audio.getStreamMaxVolume (AudioManager.STREAM_MUSIC)))
    	{
    		audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
    	}
    	
    }
}