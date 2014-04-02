package org.gitmad.topicbingo.view;

import org.gitmad.topicbingo.R;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TimerActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_game_screen);
	}
	
	public void startTimer(View v)
	{
		EditText text = (EditText) findViewById(R.id.gameTimeEditText);
	    int i = Integer.parseInt(text.getText().toString());
	    Intent intent = new Intent(this, TimerBroadcastReceiver.class);
	    PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
	    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
	    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
	        + (i * 1000 * 60), pendingIntent); //i * 1000 * 60 = number of minutes.
	    Toast.makeText(this, "Alarm set in " + i + " minutes",
	        Toast.LENGTH_LONG).show();
	    this.sendBroadcast(intent);
	}
	
	

}
