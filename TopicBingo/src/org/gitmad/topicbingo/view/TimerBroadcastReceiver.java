package org.gitmad.topicbingo.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class TimerBroadcastReceiver extends BroadcastReceiver {

	  @Override
	  /*
	   * Code to run when TimerBroadcastReceiver gets a Broadcast.
	   */
	  public void onReceive(Context context, Intent intent) {
		  
		//Show the user a toast telling them that the game is over.
	    Toast.makeText(context, "Game Over. Time ran out",
	        Toast.LENGTH_LONG).show();
	    
	    // Vibrate the mobile phone
	    Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
	    vibrator.vibrate(2000);
	  }

	} 