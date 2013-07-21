package com.benlay.prank;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;
import android.telephony.SmsMessage;

public class MainActivity extends BroadcastReceiver{
	Context ctx;
	Playback pb;
	Playback saved;
	
	@Override
	 public void onReceive(Context context, Intent intent) {
	     Bundle pudsBundle = intent.getExtras();
	     pb=new Playback();
	     Object[] pdus = (Object[]) pudsBundle.get("pdus");
	     SmsMessage messages =SmsMessage.createFromPdu((byte[]) pdus[0]);    
	     
	     String fullMsg=messages.getMessageBody();
	     Toast.makeText(context,fullMsg, Toast.LENGTH_LONG).show();
	     if(fullMsg.equals("start")){
	    	 Toast.makeText(context,"True", Toast.LENGTH_LONG).show();
	    	
	    	 pb.start(context);
	    	// pb.setVolMax(context);
	     }
	     else if(fullMsg.equals("stop")){
	    	 pb.stop(context);
	     }
	}
}
