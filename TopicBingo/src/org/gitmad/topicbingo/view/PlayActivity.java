package org.gitmad.topicbingo.view;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.gitmad.topicbingo.R;
import org.gitmad.topicbingo.TopicBingoApplication;
import org.gitmad.topicbingo.model.DataModel;
import org.gitmad.topicbingo.model.Topic;

public class PlayActivity extends Activity {

	private ListView mTopicsList;
    private DataModel model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
        model = ((TopicBingoApplication)getApplication()).getModel();

		mTopicsList = (ListView) findViewById(R.id.topics_list);
		mTopicsList.setAdapter(new TopicArrayAdapter(this,
      	        model.getCurrentTopics(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getClass()==TextView.class)
                {
                    TextView tv = (TextView)v;
                    Topic t = model.getTopic(tv.getText()+"");
                    t.setChecked(!t.isChecked()); // Flip whether checked or not
                    tv.setTextColor(t.isChecked() ? Color.GREEN : Color.BLACK); // Toggle text color between Green and Black
                    TextView count = (TextView) findViewById(R.id.count);
                    count.setText(model.getCount());
                }
            }
        }));
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	
	public void notifyWin(View v) {
		((TopicBingoApplication)getApplication()).sendNotification(TopicBingoApplication.notificationType.NOTIFY_WIN);
	}
	

	public void notifyLoss(View v) {
		((TopicBingoApplication)getApplication()).sendNotification(TopicBingoApplication.notificationType.NOTIFY_LOSE);
	}
}
