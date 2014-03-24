package org.gitmad.topicbingo;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.test.ApplicationTestCase;
import org.gitmad.topicbingo.model.DataModel;
import org.gitmad.topicbingo.view.PlayActivity;

/**
 * Created by Alex on 2/24/14.
 */
public class TopicBingoApplication extends Application {
	private static DataModel model;
	private List<NotificationCompat.Builder> mNotifList; // Implemented as 
	// list to allow for multiple notifications to be tracked (index is id - 1)
	private NotificationManager mNotificationManager;
	private Results mResults;
	public static enum notificationType {NOTIFY_WIN, NOTIFY_LOSE};
	
	
	public DataModel getModel() {
		return model;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		model = new DataModel(this);
		mNotifList = new ArrayList<NotificationCompat.Builder>();
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mResults = new Results();
	}

	/**
	 * This allows the sending and tracking of notifications for the application, to allow for updating
	 * @param type
	 */
	public void sendNotification(notificationType type) {
		
		int nId = 0;
		NotificationCompat.Builder mBuilder = null;
		
		if (mNotifList.isEmpty()) {
			mBuilder = new NotificationCompat.Builder(this);
			mBuilder.setSmallIcon(R.drawable.ic_topic_bingo_logo);
			mBuilder.setContentTitle(R.string.game_over +""); // This handles most cases, for others, we can override it
			mBuilder.setAutoCancel(true);
			mNotifList.add(mBuilder);

			nId = 1;
		} else {
			nId = 1; // To expand this, make a way to choose which nId to change
			mBuilder = mNotifList.get(nId-1);
		}
		
		switch (type) {
		case NOTIFY_WIN:
			String wText = R.string.victory_text+""; // Made temp variable to avoid looking up string many times
			mResults.addWin(wText);
			mBuilder.setContentText(wText);
			mBuilder.setTicker(wText);
			mBuilder.setNumber(mResults.getCount());
//			mBuilder.setSmallIcon(R.drawable.crown); // doesn't seem to do what is expected
			break;
		case NOTIFY_LOSE:
			String lText = R.string.loss_text+""; // same slight optimization
			mResults.addLoss(lText);
			mBuilder.setContentText(lText);
			mBuilder.setTicker(lText);
			mBuilder.setNumber(mResults.getCount());
//			mBuilder.setSmallIcon(android.R.drawable.ic_menu_close_clear_cancel); // doesn't seem to do what is expected
			break;
		}

		// If there is more than one game being reported, add big style too
		if (mResults.getCount() > 1) {
			NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
			inboxStyle.setBigContentTitle(R.string.game_outcome_notification_title+"");
			for (String s : mResults.getEvents()) {
				inboxStyle.addLine(s);
			}
			mBuilder.setStyle(inboxStyle);
		}
		
		Intent resultIntent = new Intent(this, PlayActivity.class);
		
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(PlayActivity.class);
		stackBuilder.addNextIntent(resultIntent);
		
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		
		mNotificationManager.notify(nId, mBuilder.build());
	}
	
	private class Results {
		private int wins, losses;
		private List<String> results;
		
		public Results() {
			results = new ArrayList<String>();
			clearAll();
		}
		
		public int getCount() {
			return results.size();
		}

		public void addWin(String res) {
			wins++;
			results.add(res);
		}
		public void addLoss(String res) {
			losses++;
			results.add(res);
		}
		public void clearAll() { // TODO call when notification is opened / dismissed
			wins = 0; losses = 0;
			results.clear();
		}
		public List<String> getEvents() {
			return results;
		}
	}
}
